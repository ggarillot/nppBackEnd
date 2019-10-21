package com.npp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.npp.service.StandardUserService;
import com.npp.service.SubscriptionService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:8034")
public class StandardUserController {
	@Autowired
	private StandardUserService standardUserService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public StandardUser add(@RequestBody StandardUser user) {
		return standardUserService.add(user);
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public StandardUser update(@RequestBody StandardUser user, @PathVariable long id) {
		if (standardUserService.getById(id) == null ) {
			return null;
		} else {
			return standardUserService.update(user);
		}
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		if(standardUserService.getById(id) != null) {
			standardUserService.delete(id);
		}
	}
	
	@RequestMapping(value="get/{id}", method = RequestMethod.GET)
	public StandardUser getById(@PathVariable long id) {
		if (standardUserService.getById(id) != null) {
			return standardUserService.getById(id);
		} else {
			return null;
		}
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public List<StandardUser> findAll() {
		return standardUserService.findAll();
	}

}
