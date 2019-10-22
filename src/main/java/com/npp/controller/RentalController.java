package com.npp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.npp.service.RentalService;

@RestController
@RequestMapping("/rental")
@CrossOrigin(origins = "http://localhost:8034")
public class RentalController {
	@Autowired
	private RentalService RentalService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Rental add(@RequestBody Rental rental) {
		return RentalService.add(rental);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public Rental update(@RequestBody Rental rental, @PathVariable long id) {
		if (RentalService.getById(id) == null) {
			return null;
		} else {
			return RentalService.update(rental);
		}
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		if (RentalService.getById(id) != null) {
			RentalService.delete(id);
		}
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Rental getById(@PathVariable long id) {
		if (RentalService.getById(id) != null) {
			return RentalService.getById(id);
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public List<Rental> findAll() {
		return RentalService.findAll();
	}

}
