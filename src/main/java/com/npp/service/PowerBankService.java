package com.npp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npp.entity.GenericStation;
import com.npp.entity.PowerBank;
import com.npp.iservice.IPowerBankService;
import com.npp.repository.IPowerBankRepository;

@Service
public class PowerBankService extends AbstractService<PowerBank, Long> implements IPowerBankService {

	@Autowired
	public PowerBankService(IPowerBankRepository repository) {
		this.repository = repository;
	}

	@Override
	public PowerBank attachToStation(PowerBank powerBank, GenericStation station) throws Exception {

		if (station.getNSlots() - station.getPowerBankList().size() <= 0)
			throw new Exception("no slots available");

		if (powerBank.getGenericStation() != null)
			throw new Exception("PowerBank already in a station");
		
		powerBank.setGenericStation(station);
		return this.update(powerBank, powerBank.getId());
	}
	
	@Override
	public PowerBank detachOfStation(PowerBank powerBank) throws Exception {
		
		if (powerBank.getGenericStation() == null)
			throw new Exception("PowerBank not in a station");
		
		powerBank.setGenericStation(null);
		return this.update(powerBank, powerBank.getId());
	}

	@Override
	public List<PowerBank> findByGenericStation(GenericStation genericstation) {
		return ((IPowerBankRepository) repository).findByGenericStation(genericstation);
	}



}
