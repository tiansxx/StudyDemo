package com.tian.exception;

public class MyCustomException extends Exception {

	private static final long serialVersionUID = 1L;

	public MyCustomException() {
	}
	
	public MyCustomException(String errMsg) {
		super(errMsg);
	}
	
}
