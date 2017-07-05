package com.tian.thread.exception;

public class ThreadExceptionMain {

	public static void main(String[] args) {

		Thread.UncaughtExceptionHandler handler = new Thread.UncaughtExceptionHandler() {

			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("UncaughtException: " + e);
			}
		};

		Thread t = new Thread() {
			public void run() {
				System.out.println("Thread start ...");
				throw new RuntimeException("Thread runtime exception.");
			}
		};

		t.setUncaughtExceptionHandler(handler);
		t.start();
	}

}
