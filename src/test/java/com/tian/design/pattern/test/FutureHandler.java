package com.tian.design.pattern.test;

public class FutureHandler {

	public void onSuccess(String val, SimpleFuture future) {
		future.complete(val);
	}
	
}
