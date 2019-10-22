package com.npp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.npp.entity.Rental;

@Repository
public interface IRentalRepository extends JpaRepository<Rental, Long> {

}
