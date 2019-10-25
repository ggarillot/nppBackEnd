package com.npp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

}
