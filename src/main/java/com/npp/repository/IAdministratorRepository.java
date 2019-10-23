package com.npp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.npp.entity.Administrator;
import java.lang.String;

@Repository
public interface IAdministratorRepository extends JpaRepository<Administrator, Long> {

	List<Administrator> findByName(String name);
}
