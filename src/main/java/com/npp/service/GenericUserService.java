package com.npp.service;

import org.springframework.stereotype.Service;

import com.npp.entity.GenericUser;
import com.npp.iservice.IGenericUserService;

@Service
public class GenericUserService extends AbstractService<GenericUser, Long> implements IGenericUserService {

}
