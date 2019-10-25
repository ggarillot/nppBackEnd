package com.npp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.npp.entity.PowerBank;
import com.npp.entity.GenericStation;
import java.util.List;

@Repository
public interface IPowerBankRepository extends JpaRepository<PowerBank, Long> {

	List<PowerBank> findByGenericStation(GenericStation genericstation);
}
