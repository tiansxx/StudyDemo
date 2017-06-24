package com.tian.timeout.v1;

/**
 * 
 * @author tian
 */

public class TimeoutException extends RuntimeException {

	private static final long serialVersionUID = 2612710033306302500L;

	public TimeoutException(String message) {
		super(message);
	}
	
}
