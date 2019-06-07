package com.tian.concurrent.test;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExceptionTest {
	
	public static void main(String[] args) {
		
		UncaughtExceptionHandler uncaughtExceptionHandler = new UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("uncaughtExceptionHandler\t" + t);
				e.printStackTrace();
			}
		};
		
		ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>(), new ThreadFactory() {
			
			@Override
			public Thread newThread(Runnable r) {
				Thread thread = new Thread(r, "tian" + System.currentTimeMillis());
//				thread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
				return thread;
			}
		});
		
		executor.execute(new Task());
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		executor.execute(new Task());
		
	}
	
	static class Task implements Runnable {

		@Override
		public void run() {
			int count = 0;
			while (true) {
				count++;
				System.out.println(Thread.currentThread().getId() + "\t=============== >> " + count);
				if (count == 10) {
//					try {
						System.out.println(count / 0);
//					} catch (Exception e) {
//						System.out.println(e);
//					}
				}
				if (count == 20) {
					System.out.println(Thread.currentThread().getId() + "\tcount = 20");
					break;
				}
			}
		}
		
	}
	
}
