package com.npp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.npp.service.PowerBankService;

@RestController
@RequestMapping("/powerBank")
@CrossOrigin(origins = "http://localhost:8034")
public class PowerBankController {
	@Autowired
	private PowerBankService powerBankService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public PowerBank add(@RequestBody PowerBank powerBank) {
		return powerBankService.add(powerBank);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public PowerBank update(@RequestBody PowerBank powerBank, @PathVariable long id) {
		if (powerBankService.getById(id) == null) {
			return null;
		} else {
			return powerBankService.update(powerBank);
		}
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		if (powerBankService.getById(id) != null) {
			powerBankService.delete(id);
		}
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public PowerBank getById(@PathVariable long id) {
		if (powerBankService.getById(id) != null) {
			return powerBankService.getById(id);
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public List<PowerBank> findAll() {
		return powerBankService.findAll();
	}

}
