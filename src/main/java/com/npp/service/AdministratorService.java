package com.npp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npp.entity.Administrator;
import com.npp.iservice.IAdministratorService;
import com.npp.repository.IAdministratorRepository;

@Service
public class AdministratorService extends AbstractService<Administrator, Long> implements IAdministratorService {
	
	@Autowired
	public AdministratorService (IAdministratorRepository repository) {
		this.repository = repository;
	}
}
