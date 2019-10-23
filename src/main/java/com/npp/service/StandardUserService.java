package com.npp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npp.entity.StandardUser;
import com.npp.iservice.IStandardUserService;
import com.npp.repository.IStandardUserRepository;

@Service
public class StandardUserService extends AbstractService<StandardUser, Long> implements IStandardUserService {

	@Autowired
	public StandardUserService (IStandardUserRepository repository) {
		this.repository = repository;
	}


}
