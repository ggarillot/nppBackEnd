package com.npp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.npp.entity.GenericUser;
import com.npp.iservice.IGenericUserService;
import com.npp.repository.IGenericUserRepository;

@Service
public class GenericUserService extends AbstractService<GenericUser, Long> implements IGenericUserService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public GenericUserService (IGenericUserRepository repository) {
		this.repository = repository;
	}

	@Override
	public GenericUser findByEmail(String email) {
		return ((IGenericUserRepository)repository).findByEmail(email);
	}
	
	@Override
	public GenericUser add(GenericUser g) {
		g.setPassword(passwordEncoder.encode(g.getPassword()));
		return repository.save(g);
	}
	
	@Override
	public GenericUser update(GenericUser g) {
		g.setPassword(passwordEncoder.encode(g.getPassword()));
		return repository.save(g);
	}

}
