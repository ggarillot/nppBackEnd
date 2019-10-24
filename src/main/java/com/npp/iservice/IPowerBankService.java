package com.npp.iservice;

import com.npp.entity.GenericStation;
import com.npp.entity.PowerBank;

public interface IPowerBankService extends IAbstractService<PowerBank, Long> {

	PowerBank attachToStation(PowerBank powerBank, GenericStation station) throws Exception;
}
