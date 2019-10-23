package com.npp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npp.entity.Subscription;
import com.npp.iservice.ISubscriptionService;

@RestController
@RequestMapping("/subscription")
@CrossOrigin(origins = "http://localhost:8034")
public class SubscriptionController extends AbstractController<Subscription, Long>{
	
	@Autowired
	public SubscriptionController(ISubscriptionService service)
	{
		this.service = service;
	}
	
}
