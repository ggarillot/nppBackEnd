package com.npp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npp.iService.Administrator;
import com.npp.iService.IAdministratorService;
import com.npp.iService.IGenericService;
import com.npp.iService.Optional;
import com.npp.repository.IAdministratorRepository;

@Service
public class AdministratorService implements IGenericService<Administrator> {
	@Autowired
	private IAdministratorRepository administratorRepository;
	
	@Override
	public Administrator add(Administrator a) {
		return administratorRepository.save(a);
	}

	@Override
	public Administrator update(Administrator a) {
		return administratorRepository.save(a);
	}

	@Override
	public void delete(Long id) {
		administratorRepository.deleteById(id);
	}

	@Override
	public Optional<Administrator> getById(Long id) {
		return administratorRepository.findById(id);
	}

	@Override
	public List<Administrator> findAll() {
		return administratorRepository.findAll();
	}
	

}
