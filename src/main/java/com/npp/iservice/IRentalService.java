package com.npp.iservice;

import java.util.List;

import com.npp.entity.GenericUser;
import com.npp.entity.PowerBank;
import com.npp.entity.Rental;
import com.npp.exception.RentalNotAllowedException;

public interface IRentalService extends IAbstractService<Rental, Long> {

	List<Rental> findByGenericUser(GenericUser genericuser);

	/**
	 * Function to handle a rental
	 * 
	 * @param user      : The user who rents the powerBank
	 * @param powerBank : The Power Bank rented by the user
	 * @return
	 * @throws RentalNotAllowedException
	 */
	Rental handleNewRent(GenericUser user, PowerBank powerBank) throws RentalNotAllowedException;
}
