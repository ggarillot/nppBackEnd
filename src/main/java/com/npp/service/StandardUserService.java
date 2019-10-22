package com.npp.service;

import org.springframework.stereotype.Service;

import com.npp.entity.StandardUser;
import com.npp.iservice.IStandardUserService;

@Service
public class StandardUserService extends AbstractService<StandardUser, Long> implements IStandardUserService {



}
