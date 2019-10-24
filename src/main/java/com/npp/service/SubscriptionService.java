package com.npp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npp.entity.GenericUser;
import com.npp.entity.Subscription;
import com.npp.iservice.ISubscriptionService;
import com.npp.repository.ISubscriptionRepository;

@Service
public class SubscriptionService extends AbstractService<Subscription, Long> implements ISubscriptionService {

	@Autowired
	public SubscriptionService(ISubscriptionRepository repository) {
		this.repository = repository;

	}

	@Override
	public List<Subscription> findByGenericUser(GenericUser genericuser) {
		return ((ISubscriptionRepository) repository).findByGenericUser(genericuser);
	}
}
