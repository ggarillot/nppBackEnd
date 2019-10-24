package com.npp.exception;

public class RentalNotAllowedException extends Exception {

	private static final long serialVersionUID = 1L;

	public RentalNotAllowedException(String msg) {
		super(msg);
	}
}
