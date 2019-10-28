package com.npp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.npp.entity.GenericUser;
import com.npp.entity.User;
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
	
	@RequestMapping(value = "/getuser/{username}", method = RequestMethod.GET)
	public GenericUser findByUsername(@PathVariable String username) {
		return ((IGenericUserService)service).findByUsername(username);
	}
	
	@GetMapping(produces = "application/json")
	@RequestMapping("/validateLogin")
	public User validateLogin() {
		return User.builder().status("User successfully authenticated").build();
	}
	
}
