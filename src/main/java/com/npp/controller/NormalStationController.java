package com.npp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.npp.service.NormalStationService;

@RestController
@RequestMapping("/station")
@CrossOrigin(origins = "http://localhost:8034")
public class NormalStationController {
	@Autowired
	private NormalStationService NormalStationService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public NormalStation add(@RequestBody NormalStation normalStation) {
		return NormalStationService.add(normalStation);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public NormalStation update(@RequestBody NormalStation normalStation, @PathVariable long id) {
		if (NormalStationService.getById(id) == null) {
			return null;
		} else {
			return NormalStationService.update(normalStation);
		}
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		if (NormalStationService.getById(id) != null) {
			NormalStationService.delete(id);
		}
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public NormalStation getById(@PathVariable long id) {
		if (NormalStationService.getById(id) != null) {
			return NormalStationService.getById(id);
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public List<NormalStation> findAll() {
		return NormalStationService.findAll();
	}

}
