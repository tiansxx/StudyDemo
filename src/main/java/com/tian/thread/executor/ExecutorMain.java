package com.tian.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorMain {

	static class Task implements Runnable {

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + "#" + Thread.currentThread().getId() );
		}
		
	}
	
	public static void main(String[] args) {
		ExecutorService exec = null;
		
		exec = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 2);
//		exec = Executors.newCachedThreadPool();
//		exec = Executors.newSingleThreadExecutor();
		
//		Executors.newSingleThreadScheduledExecutor();
		
		for (int i = 0; i < 10; i++) {
			exec.execute(new Task());
		}
		
		exec.shutdown();
		
	}
}
