package com.npp.service;

import org.springframework.stereotype.Service;

import com.npp.entity.Subscription;
import com.npp.iservice.ISubscriptionService;

@Service
public class SubscriptionService extends AbstractService<Subscription, Long> implements ISubscriptionService {

}
