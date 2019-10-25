package com.npp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.npp.entity.Rental;
import com.npp.entity.GenericUser;
import java.util.List;
import com.npp.entity.PowerBank;

@Repository
public interface IRentalRepository extends JpaRepository<Rental, Long> {

	List<Rental> findByGenericUser(GenericUser genericuser);
	List<Rental> findByPowerBank(PowerBank powerBank);
}
