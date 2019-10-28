package com.npp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.npp.entity.GenericStation;
import com.npp.entity.GenericUser;
import com.npp.entity.PowerBank;
import com.npp.entity.Rental;
import com.npp.entity.Subscription;
import com.npp.exception.RentalNotAllowedException;
import com.npp.iservice.IGenericStationService;
import com.npp.iservice.IGenericUserService;
import com.npp.iservice.IPowerBankService;
import com.npp.iservice.IRentalService;
import com.npp.iservice.ISubscriptionService;
import com.npp.repository.IRentalRepository;

@Service
public class RentalService extends AbstractService<Rental, Long> implements IRentalService {

	@Autowired
	public RentalService(IRentalRepository repository) {
		this.repository = repository;
	}

	@Autowired
	ISubscriptionService subscriptionService;

	@Autowired
	IGenericUserService userService;

	@Autowired
	IPowerBankService powerBankService;

	@Autowired
	IGenericStationService stationService;

	@Override
	public List<Rental> findByGenericUser(GenericUser genericuser) {
		return ((IRentalRepository) repository).findByGenericUser(genericuser);
	}

	@Override
	public List<Rental> findByPowerBank(PowerBank powerBank) {
		return ((IRentalRepository) repository).findByPowerBank(powerBank);
	}

	@Override
	public Rental userCurrentRent(GenericUser user) {

		Rental userRental = null;
		List<Rental> userRentalList = this.findByGenericUser(user);
		for (Rental rental : userRentalList) {
			if (rental.getEndDate() == null) {
				userRental = rental;
				break;
			}
		}
		return userRental;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Rental handleNewRent(GenericUser user, PowerBank powerBank) throws RentalNotAllowedException {
		System.out.println("handleNewRent");
		List<Subscription> userSuscriptionList = subscriptionService.findByGenericUser(user);

		// osef subscribe
		boolean isSuscribed = true;
		LocalDate now = LocalDate.now();
		for (Subscription suscription : userSuscriptionList) {
			if (suscription.getEndDate().compareTo(now) >= 0) {
				isSuscribed = true;
				break;
			}
		}

		Rental userRental = userCurrentRent(user);

		try {
			powerBankService.detachOfStation(powerBank);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RentalNotAllowedException("Battery not in a station");
		}

		if (!isSuscribed)
			throw new RentalNotAllowedException("User not suscribed");
		if (userRental != null)
			throw new RentalNotAllowedException("User already in rent");

		Rental rental = new Rental();
		rental.setGenericUser(user);
		rental.setPowerBank(powerBank);
		rental.setBeginDate(now);
		rental.setLimitDate(now.plusDays(1));

		rental = this.add(rental);

		return rental;

	}

	@Override
	public Rental handleEndOfRental(Rental rental, GenericStation station) throws Exception {

		rental.setEndDate(LocalDate.now());
		PowerBank powerBank = rental.getPowerBank();

		powerBankService.attachToStation(powerBank, station);

		return repository.save(rental);
	}

}
