package com.stupin.core.service.exception;

public class UserNotFoundException extends  RuntimeException{

	public UserNotFoundException(String message) {
		super(message);
	}
}
