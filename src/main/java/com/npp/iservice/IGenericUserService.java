package com.npp.iservice;

import com.npp.entity.GenericUser;

public interface IGenericUserService extends IAbstractService<GenericUser, Long> {
	public GenericUser findByUsername(String username);
}
