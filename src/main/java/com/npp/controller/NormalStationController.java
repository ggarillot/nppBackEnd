package com.npp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npp.entity.NormalStation;
import com.npp.iservice.INormalStationService;

@RestController
@RequestMapping("/station")
@CrossOrigin(origins = "*")

public class NormalStationController extends AbstractController<NormalStation, Long>{
	
	@Autowired
	public NormalStationController(INormalStationService service)
	{
		this.service = service;
	}
	
}
