package com.npp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npp.iService.IGenericService;
import com.npp.iService.ISubscriptionService;
import com.npp.iService.Subscription;
import com.npp.repository.ISubscriptionRepository;

@Service
public class SubscriptionService implements IGenericService<Subscription> {
	@Autowired
	private ISubscriptionRepository subscriptionRepository;

	@Override
	public Subscription add(Subscription g) {
		return subscriptionRepository.save(g);
	}

	@Override
	public Subscription update(Subscription g) {
		return subscriptionRepository.save(g);
	}

	@Override
	public void delete(Long id) {
		subscriptionRepository.deleteById(id);
	}

	@Override
	public Optional<Subscription> getById(Long id) {
		return subscriptionRepository.findById(id);
	}

	@Override
	public List<Subscription> findAll() {
		return subscriptionRepository.findAll();
	}
	
	

}
