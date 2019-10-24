package com.npp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npp.entity.GenericUser;
import com.npp.iservice.IGenericUserService;

@RestController
@RequestMapping("/guser")
@CrossOrigin(origins = "*")
public class GenericUserController extends AbstractController<GenericUser, Long> {
	
	@Autowired
	public GenericUserController(IGenericUserService service)
	{
		this.service = service;
	}

}
