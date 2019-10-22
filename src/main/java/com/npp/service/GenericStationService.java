package com.npp.service;

import org.springframework.stereotype.Service;

import com.npp.entity.GenericStation;
import com.npp.iservice.IGenericStationService;

@Service
public class GenericStationService extends AbstractService<GenericStation, Long> implements IGenericStationService {

}
