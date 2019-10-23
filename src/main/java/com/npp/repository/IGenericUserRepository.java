package com.npp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.npp.entity.GenericUser;

@Repository
public interface IGenericUserRepository extends JpaRepository<GenericUser, Long> {
	public GenericUser findByEmail(String email);

}
