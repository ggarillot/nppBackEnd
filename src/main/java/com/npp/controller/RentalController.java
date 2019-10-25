package com.npp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npp.entity.Rental;
import com.npp.exception.RentalNotAllowedException;
import com.npp.iservice.IRentalService;

@RestController
@RequestMapping("/rental")
@CrossOrigin(origins = "*")
public class RentalController extends AbstractController<Rental, Long> {

	@Autowired
	public RentalController(IRentalService service) {
		this.service = service;
	}

	@Override
	@PostMapping("/add")
	public ResponseEntity<Rental> add(@RequestBody Rental g) {

		try {
			g = ((IRentalService) service).handleNewRent(g.getGenericUser(), g.getPowerBank());
		} catch (RentalNotAllowedException e) {
			e.printStackTrace();
			return new ResponseEntity<Rental>(HttpStatus.FORBIDDEN);
		}

		return new ResponseEntity<Rental>(g, HttpStatus.OK);
	}

}
