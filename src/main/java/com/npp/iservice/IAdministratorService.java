package com.npp.iservice;

import java.util.List;

import com.npp.entity.Administrator;

public interface IAdministratorService extends IAbstractService<Administrator, Long> {
	List<Administrator> findByName(String name);
}
