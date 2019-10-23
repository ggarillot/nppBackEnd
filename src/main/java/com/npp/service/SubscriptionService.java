package com.npp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npp.entity.Subscription;
import com.npp.iservice.ISubscriptionService;
import com.npp.repository.ISubscriptionRepository;

@Service
public class SubscriptionService extends AbstractService<Subscription, Long> implements ISubscriptionService {
	
	@Autowired
	public SubscriptionService (ISubscriptionRepository repository) {
		this.repository = repository;
	}

}
