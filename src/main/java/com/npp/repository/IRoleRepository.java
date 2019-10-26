package com.npp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.npp.entity.GenericUser;

@Repository
public interface IRoleRepository extends JpaRepository<GenericUser, Long> {
	
}
