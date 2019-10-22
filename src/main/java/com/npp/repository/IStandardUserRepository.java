package com.npp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.npp.entity.StandardUser;

@Repository
public interface IStandardUserRepository extends JpaRepository<StandardUser, Long> {

}
