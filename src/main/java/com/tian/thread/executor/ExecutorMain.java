package com.tian.thread.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorMain {
	
	public static ExecutorService exec = null;

	static class RunTask implements Runnable {

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + "#" + Thread.currentThread().getId() );
		}
	}
	
	static class CallTask implements Callable<String> {

		@Override
		public String call() throws Exception {
			return Thread.currentThread().getName();
		}
		
	}
	
	public static void main(String[] args) {
		int coreSize = Runtime.getRuntime().availableProcessors() + 2;
		exec = Executors.newFixedThreadPool(coreSize);
		
//		execute();
		submit();
		
		exec.shutdown();
	}
	
	public static void execute() {
		
//		exec = Executors.newCachedThreadPool();
//		exec = Executors.newSingleThreadExecutor();
		
//		Executors.newSingleThreadScheduledExecutor();
		
		for (int i = 0; i < 10; i++) {
			exec.execute(new RunTask());
		}
	}
	
	public static void submit() {
		CallTask task = new CallTask();
		Future<String> futures = exec.submit(task);
		String result = null;
		try {
			result = futures.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println(result);
	}
}
