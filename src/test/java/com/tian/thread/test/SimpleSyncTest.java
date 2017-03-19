package com.tian.thread.test;

/**
 * 
 * @author tian
 */

public class SimpleSyncTest {
	
	private Object monitor = new Object();
	
	public synchronized void hello() {
		System.out.println("hello");
	}
	
	public void helloAgain() {
		synchronized (monitor) {
			System.out.println("hello again");
		}
	}
	
	public static synchronized void helloWorld() {
		System.out.println("hello world");
	}
	
	public static void helloworldAgain() {
		synchronized (SimpleSyncTest.class) {
			System.out.println("hello world again");
		}
	}
	
	public static void main(String[] args) {
		
	}
	
}
