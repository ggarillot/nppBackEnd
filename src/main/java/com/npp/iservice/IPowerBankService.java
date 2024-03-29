package com.npp.iservice;

import java.util.List;

import com.npp.entity.GenericStation;
import com.npp.entity.PowerBank;

public interface IPowerBankService extends IAbstractService<PowerBank, Long> {

	PowerBank attachToStation(PowerBank powerBank, GenericStation station) throws Exception;
	PowerBank detachOfStation(PowerBank powerBank) throws Exception;
	
	List<PowerBank> findByGenericStation(GenericStation genericstation);
}
