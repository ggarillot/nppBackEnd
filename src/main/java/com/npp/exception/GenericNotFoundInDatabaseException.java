package com.npp.exception;

import org.springframework.dao.DataAccessException;

public class GenericNotFoundInDatabaseException extends DataAccessException {

	private static final long serialVersionUID = 1L;

	public GenericNotFoundInDatabaseException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

}
