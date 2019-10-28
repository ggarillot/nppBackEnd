package com.npp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npp.entity.PowerBank;
import com.npp.iservice.IPowerBankService;

@RestController
@RequestMapping("/powerBank")
@CrossOrigin(origins = "*")
public class PowerBankController extends AbstractController<PowerBank, Long> {

	@Autowired
	public PowerBankController(IPowerBankService service) {
		this.service = service;
	}

	@Override
	@PutMapping("/update")
	public ResponseEntity<PowerBank> update(@RequestBody PowerBank powerBank) {

		try {
			powerBank = ((IPowerBankService) service).attachToStation(powerBank, powerBank.getGenericStation());
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<PowerBank>(HttpStatus.FORBIDDEN);
		}

		return new ResponseEntity<PowerBank>(powerBank, HttpStatus.OK);
	}
}
