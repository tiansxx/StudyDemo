package com.tian.reflect;

public class Basic {

	public Basic() {
		System.out.println("com.tian.reflect.Basic initlize");
	}
	
	void print() {
		print("hello world");
	}
	
	public void print(String str) {
		System.out.println("=========" + str);
	}
	
}
