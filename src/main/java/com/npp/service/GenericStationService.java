package com.npp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npp.entity.GenericStation;
import com.npp.iservice.IGenericStationService;
import com.npp.repository.IGenericStationRepository;

@Service
public class GenericStationService extends AbstractService<GenericStation, Long> implements IGenericStationService {
	
	@Autowired
	public GenericStationService (IGenericStationRepository repository) {
		this.repository = repository;
	}

}
