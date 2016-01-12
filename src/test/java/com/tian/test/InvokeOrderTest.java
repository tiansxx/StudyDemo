package com.tian.test;

import org.junit.Test;

public class InvokeOrderTest {

	@Test
	public void invokeOrder() {
		print1(print2());
	}
	
	private void print1(String s) {
		System.out.println("print1");
	}
	
	private String print2() {
		System.out.println("print2");
		return "print2";
	}
}
