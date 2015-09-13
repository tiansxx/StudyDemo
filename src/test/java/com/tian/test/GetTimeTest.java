package com.tian.test;

public class GetTimeTest {

	public static void main(String[] args) {
		long currentTimeMillis = System.currentTimeMillis();
		
		long nanoTime = System.nanoTime();
		System.out.println(currentTimeMillis);
		System.out.println(nanoTime);
	}
}
