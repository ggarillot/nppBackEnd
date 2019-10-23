package com.npp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npp.entity.Rental;
import com.npp.iservice.IRentalService;
import com.npp.repository.IRentalRepository;

@Service
public class RentalService extends AbstractService<Rental, Long> implements IRentalService {
	
	@Autowired
	public RentalService (IRentalRepository repository) {
		this.repository = repository;
	}


}
