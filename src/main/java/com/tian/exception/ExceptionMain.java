package com.tian.exception;

public class ExceptionMain {

	public static void main(String[] args) {
		
		MyCustomException myCustomException = new MyCustomException("Illegal Exception");
		try {
			throw myCustomException;
		} catch (MyCustomException e) {
			e.printStackTrace();
		}
		
		MyCustomRuntimeException myCustomRuntimeException = 
				new MyCustomRuntimeException("my custome runtime exception");
		
		throw myCustomRuntimeException;
		
		
	}
}
