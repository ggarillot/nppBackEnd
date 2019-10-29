package com.npp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npp.entity.GenericStation;
import com.npp.entity.PowerBank;
import com.npp.entity.Rental;
import com.npp.iservice.IGenericStationService;
import com.npp.iservice.IPowerBankService;
import com.npp.iservice.IRentalService;
import com.npp.repository.IGenericStationRepository;

@Service
public class GenericStationService extends AbstractService<GenericStation, Long> implements IGenericStationService {

	@Autowired
	private IPowerBankService powerBankService;

	@Autowired
	private IRentalService rentalService;

	@Autowired
	public GenericStationService(IGenericStationRepository repository) {
		this.repository = repository;
	}

	/**
	 * dirty but whatever
	 */
	@Override
	public void addPowerBankToStation(GenericStation station) throws Exception {
		List<PowerBank> powerBankList = powerBankService.findAll();
		for (PowerBank pb : powerBankList) {
			if (pb.getGenericStation() == null) {
				List<Rental> rental = rentalService.findByPowerBank(pb);
				if (rental.size() == 0) {
					powerBankService.attachToStation(pb, station);
					break;
				}
			}
		}
	}

}
