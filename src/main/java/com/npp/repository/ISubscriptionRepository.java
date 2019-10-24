package com.npp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.npp.entity.Subscription;
import com.npp.entity.GenericUser;
import java.util.List;

@Repository
public interface ISubscriptionRepository extends JpaRepository<Subscription, Long> {

	List<Subscription> findByGenericUser(GenericUser genericuser);
}
