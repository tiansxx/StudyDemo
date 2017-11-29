package com.tian.design.pattern.test;

public class SimpleFutureCompletionHandler extends SimpleFuture {
	
	public void onComplete(String val) {
		fireSuccess(val);
	}
	
}
