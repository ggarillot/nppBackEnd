package com.npp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npp.entity.PowerBank;
import com.npp.iservice.IPowerBankService;
import com.npp.repository.IPowerBankRepository;

@Service
public class PowerBankService extends AbstractService<PowerBank, Long> implements IPowerBankService {
	
	@Autowired
	public PowerBankService (IPowerBankRepository repository) {
		this.repository = repository;
	}


}
