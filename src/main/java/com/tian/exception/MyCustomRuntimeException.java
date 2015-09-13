package com.tian.exception;

public class MyCustomRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MyCustomRuntimeException() {
	}
	
	public MyCustomRuntimeException(String message) {
		super(message);
	}
	
}
