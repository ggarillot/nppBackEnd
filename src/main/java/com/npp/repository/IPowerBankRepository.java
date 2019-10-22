package com.npp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPowerBankRepository extends JpaRepository<PowerBank, Long> {

}
