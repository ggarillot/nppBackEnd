package com.npp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npp.iService.IGenericService;
import com.npp.iService.IStandardUserService;
import com.npp.iService.Optional;
import com.npp.iService.StandardUser;
import com.npp.repository.IStandardUserRepository;

@Service
public class StandardUserService implements IGenericService<StandardUser> {
	@Autowired
	private IStandardUserRepository standardUserRepository;
	
	@Override
	public StandardUser add(StandardUser g) {
		return standardUserRepository.save(g);
	}

	@Override
	public StandardUser update(StandardUser g) {
		return standardUserRepository.save(g);
	}

	@Override
	public void delete(Long id) {
		standardUserRepository.deleteById(id);
	}

	@Override
	public Optional<StandardUser> getById(Long id) {
		return standardUserRepository.findById(id);
	}

	@Override
	public List<StandardUser> findAll() {
		return standardUserRepository.findAll();
	}

}
