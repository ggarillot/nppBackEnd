package com.npp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.npp.service.AdministratorService;

@RestController
@RequestMapping("/administrator")
@CrossOrigin(origins = "http://localhost:8034")
public class AdministratorController {
	@Autowired
	private AdministratorService administrationService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Administrator add(@RequestBody Administrator administrator) {
		return administrationService.add(Administrator);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public Administrator update(@RequestBody Administrator administrator, @PathVariable long id) {
		if (administrationService.getById(id) == null) {
			return null;
		} else {
			return administrationService.update(administrator);
		}
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		if (administrationService.getById(id) != null) {
			administrationService.delete(id);
		}
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Administrator getById(@PathVariable long id) {
		if (administrationService.getById(id) != null) {
			return administrationService.getById(id);
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public List<Administrator> findAll() {
		return administrationService.findAll();
	}

}
