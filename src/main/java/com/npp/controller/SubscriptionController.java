package com.npp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.npp.service.SubscriptionService;

@RestController
@RequestMapping("/subscription")
@CrossOrigin(origins = "http://localhost:8034")
public class SubscriptionController {
	@Autowired
	private SubscriptionService subscriptionService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Subscription add(@RequestBody Subscription subscription) {
		return subscriptionService.add(subscription);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public Subscription update(@RequestBody Subscription subscription, @PathVariable long id) {
		if (subscriptionService.getById(id) == null) {
			return null;
		} else {
			return subscriptionService.update(subscription);
		}
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		if (subscriptionService.getById(id) != null) {
			subscriptionService.delete(id);
		}
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Subscription getById(@PathVariable long id) {
		if (subscriptionService.getById(id) != null) {
			return subscriptionService.getById(id);
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public List<Subscription> findAll() {
		return subscriptionService.findAll();
	}
}
