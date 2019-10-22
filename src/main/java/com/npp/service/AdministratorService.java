package com.npp.service;

import org.springframework.stereotype.Service;

import com.npp.entity.Administrator;
import com.npp.iservice.IAdministratorService;

@Service
public class AdministratorService extends AbstractService<Administrator, Long> implements IAdministratorService {
}
