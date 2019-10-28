package com.npp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npp.entity.GenericUser;
import com.npp.iservice.IGenericUserService;
import com.npp.repository.IGenericUserRepository;

@Service
public class GenericUserService extends AbstractService<GenericUser, Long> implements IGenericUserService {
	
	@Autowired
	public GenericUserService (IGenericUserRepository repository) {
		this.repository = repository;
	}

	@Override
	public GenericUser findByUsername(String username) {
		return ((IGenericUserRepository)repository).findByUsername(username);
	}

}
