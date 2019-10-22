package com.npp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.npp.entity.GenericStation;

@Repository
public interface IGenericStationRepository extends JpaRepository<GenericStation, Long> {

}
