package com.npp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npp.iService.IGenericService;
import com.npp.repository.IPowerBankRepository;

@Service
public class PowerBankService implements IGenericService<PowerBank> {
	@Autowired
	private IPowerBankRepository powerBankRepository;

	@Override
	public PowerBank add(PowerBank g) {
		return powerBankRepository.save(g);
	}

	@Override
	public PowerBank update(PowerBank g) {
		return powerBankRepository.save(g);
	}

	@Override
	public void delete(Long id) {
		powerBankRepository.deleteById(id);
	}

	@Override
	public Optional<PowerBank> getById(Long id) {
		return powerBankRepository.findById(id);
	}

	@Override
	public List<PowerBank> findAll() {
		return powerBankRepository.findAll();
	}
	
	
}
