package com.npp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npp.entity.GenericStation;
import com.npp.iservice.IGenericStationService;

@RestController
@RequestMapping("/gstation")
@CrossOrigin(origins = "*")
public class GenericStationController extends AbstractController<GenericStation, Long> {
	
	@Autowired
	public GenericStationController(IGenericStationService service)
	{
		this.service = service;
	}
}
