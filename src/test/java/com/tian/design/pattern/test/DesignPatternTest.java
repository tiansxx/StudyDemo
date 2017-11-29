package com.tian.design.pattern.test;

public class DesignPatternTest {
	
	public static void main(String[] args) {
		SimpleFutureCompletionHandler simpleFutureCompletionHandler = new SimpleFutureCompletionHandler();
		SimpleFuture future = simpleFutureCompletionHandler.compose(new FutureHandler());
		future.addListener(new SimpleFutureListener() {
			
			@Override
			public void onSuccess(String val) {
				System.out.println(val + " => success. complex adaptor design pattern.");
			}
			
			@Override
			public void onFailure() {
				System.out.println("failed.");
			}
		});
		simpleFutureCompletionHandler.onComplete("hello world.");
	}
}
