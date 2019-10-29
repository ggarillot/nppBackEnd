package com.npp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npp.entity.GenericStation;
import com.npp.entity.GenericUser;
import com.npp.entity.Rental;
import com.npp.exception.RentalNotAllowedException;
import com.npp.iservice.IGenericStationService;
import com.npp.iservice.IGenericUserService;
import com.npp.iservice.IRentalService;

@RestController
@RequestMapping("/rental")
@CrossOrigin(origins = "*")
public class RentalController extends AbstractController<Rental, Long> {

	@Autowired
	IGenericUserService userService;

	@Autowired
	IGenericStationService stationService;


	@Autowired
	public RentalController(IRentalService service) {
		this.service = service;
	}

	@Override
	@PostMapping("/add")
	public ResponseEntity<Rental> add(@RequestBody Rental g) {

		System.out.println("----- add");
		try {
			g = ((IRentalService) service).handleNewRent(g.getGenericUser(), g.getPowerBank());
		} catch (RentalNotAllowedException e) {
			e.printStackTrace();
			return new ResponseEntity<Rental>(HttpStatus.FORBIDDEN);
		}

		return new ResponseEntity<Rental>(g, HttpStatus.OK);
	}

	@GetMapping("/get/{userID}/rental")
	public ResponseEntity<Rental> getRentalFromUser(@PathVariable("userID") Long id) {
		GenericUser user = userService.getById(id);
		if (user == null)
			return new ResponseEntity<Rental>(HttpStatus.NOT_FOUND);

		Rental rental = ((IRentalService) service).userCurrentRent(user);

		// 204 if no rental
		if (rental == null)
			return new ResponseEntity<Rental>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<Rental>(rental, HttpStatus.OK);
	}

	@PutMapping("/finalize/{idStation}")
	public ResponseEntity<Rental> finalizeRent(@RequestBody Rental rental, @PathVariable("idStation") Long idStation) {

		GenericStation station = stationService.getById(idStation);
		if (station == null)
			return new ResponseEntity<Rental>(HttpStatus.NOT_FOUND);

		try {
			rental = ((IRentalService) service).handleEndOfRental(rental, station);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Rental>(HttpStatus.FORBIDDEN);
		}

		return new ResponseEntity<Rental>(rental, HttpStatus.OK);

	}
}
