package com.stupin.core.service.exception;

public class CarNotFoundException extends RuntimeException{
	public CarNotFoundException(String message) {
		super(message);
	}
}
