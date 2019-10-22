package com.npp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npp.iService.IGenericService;
import com.npp.repository.IRentalRepository;

@Service
public class RentalService implements IGenericService<Rental, Long> {
	@Autowired
	private IRentalRepository rentalRepository;

	@Override
	public Rental add(Rental g) {
		return rentalRepository.save(g);
	}

	@Override
	public Rental update(Rental g) {
		return rentalRepository.save(g);
	}

	@Override
	public void delete(Long id) {
		rentalRepository.deleteById(id);
	}

	@Override
	public Optional<Rental> getById(Long id) {
		return rentalRepository.findById(id);
	}

	@Override
	public List<Rental> findAll() {
		return rentalRepository.findAll();
	}

}
