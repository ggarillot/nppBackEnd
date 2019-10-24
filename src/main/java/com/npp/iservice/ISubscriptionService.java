package com.npp.iservice;

import java.util.List;

import com.npp.entity.GenericUser;
import com.npp.entity.Subscription;

public interface ISubscriptionService extends IAbstractService<Subscription, Long> {

	List<Subscription> findByGenericUser(GenericUser genericuser);
}
