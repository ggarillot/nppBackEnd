package com.npp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.npp.entity.NormalStation;

@Repository
public interface INormalStationRepository extends JpaRepository<NormalStation, Long> {

}
