package com.npp.iservice;

import com.npp.entity.GenericStation;

public interface IGenericStationService extends IAbstractService<GenericStation, Long> {

	void addPowerBankToStation(GenericStation station) throws Exception;
}
