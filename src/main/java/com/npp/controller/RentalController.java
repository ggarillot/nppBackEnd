package com.npp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npp.entity.Rental;
import com.npp.iservice.IRentalService;

@RestController
@RequestMapping("/rental")
@CrossOrigin(origins = "*")
public class RentalController extends AbstractController<Rental, Long>{
	
	@Autowired
	public RentalController(IRentalService service)
	{
		this.service = service;
	}
	
}
