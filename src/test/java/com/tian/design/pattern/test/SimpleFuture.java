package com.tian.design.pattern.test;

import java.util.ArrayList;
import java.util.List;

public class SimpleFuture {
	
	private List<SimpleFutureListener> listeners = new ArrayList<>(); 
	
	public void addListener(SimpleFutureListener listener) {
		this.listeners.add(listener);
	}
	
	public void fireSuccess(String val) {
		for (SimpleFutureListener listener : listeners) {
			listener.onSuccess(val);
		}
	}
	
	public void complete(String val) {
		int i = 0;
		for (SimpleFutureListener listener : listeners) {
//			System.out.println("simple future. => " + val);
			listener.onSuccess(val);
		}
	}
	
	public SimpleFuture compose(FutureHandler futureHandler) {
		SimpleFuture adapted = new SimpleFuture();
		addListener(new SimpleFutureListener() {
			
			@Override
			public void onSuccess(String val) {
				futureHandler.onSuccess(val, adapted);
			}
			
			@Override
			public void onFailure() {
				System.out.println("compose failure.");
			}
		});
		return adapted;
	}
}
