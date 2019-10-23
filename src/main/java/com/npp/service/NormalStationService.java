package com.npp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npp.entity.NormalStation;
import com.npp.iservice.INormalStationService;
import com.npp.repository.INormalStationRepository;

@Service
public class NormalStationService extends AbstractService<NormalStation, Long> implements INormalStationService {
	
	@Autowired
	public NormalStationService (INormalStationRepository repository) {
		this.repository = repository;
	}


}
