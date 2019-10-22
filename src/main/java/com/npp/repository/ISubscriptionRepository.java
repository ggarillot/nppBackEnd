package com.npp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.npp.entity.Subscription;

@Repository
public interface ISubscriptionRepository extends JpaRepository<Subscription, Long> {

}
