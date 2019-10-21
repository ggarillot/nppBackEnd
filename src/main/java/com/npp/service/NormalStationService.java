package com.npp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npp.iService.IGenericService;
import com.npp.repository.INormalStationRepository;

@Service
public class NormalStationService implements IGenericService<NormalStation> {
	@Autowired
	private INormalStationRepository normalStationRepository;

	@Override
	public NormalStation add(NormalStation g) {
		return normalStationRepository.save(g);
	}

	@Override
	public NormalStation update(NormalStation g) {
		return normalStationRepository.save(g);
	}

	@Override
	public void delete(Long id) {
		normalStationRepository.deleteById(id);
	}

	@Override
	public Optional<NormalStation> getById(Long id) {
		return normalStationRepository.findById(id);
	}

	@Override
	public List<NormalStation> findAll() {
		return normalStationRepository.findAll();
	}
	
}
