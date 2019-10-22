package com.npp.exception;

public class EntityDoesNotExistForUpdateException extends Exception {

	private static final long serialVersionUID = 1L;

	public EntityDoesNotExistForUpdateException(String msg) {
		super(msg);
	}

}
