package com.npp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npp.entity.Administrator;
import com.npp.iservice.IAdministratorService;
import com.npp.repository.IAdministratorRepository;

@Service
public class AdministratorService extends AbstractService<Administrator, Long> implements IAdministratorService {

	@Autowired
	public AdministratorService(IAdministratorRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Administrator> findByName(String name) {
		return ((IAdministratorRepository) repository).findByName(name);
	}
}
