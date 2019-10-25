package com.npp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npp.entity.StandardUser;
import com.npp.iservice.IStandardUserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class StandardUserController extends AbstractController<StandardUser, Long> {
	
	@Autowired
	public StandardUserController(IStandardUserService service)
	{
		this.service = service;
	}

}
