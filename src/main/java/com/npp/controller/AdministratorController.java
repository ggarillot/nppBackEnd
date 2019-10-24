package com.npp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npp.entity.Administrator;
import com.npp.iservice.IAdministratorService;

@RestController
@RequestMapping("/administrator")
@CrossOrigin(origins = "*")
public class AdministratorController extends AbstractController<Administrator, Long> {

	@Autowired
	public AdministratorController(IAdministratorService service)
	{
		this.service = service;
	}
}
