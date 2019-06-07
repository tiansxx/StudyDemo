package com.tian.thread;

import java.lang.reflect.Field;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadLocalDemo {

	
	public static void main(String[] args) {
		case1();
		case2();
		case3();
	}
	
	static void case1() {
		
		ThreadLocal<String> tl = new ThreadLocal<>();
		tl.set("case1");
		
		InheritableThreadLocal<String> itl = new InheritableThreadLocal<>();
		itl.set("inherit case1");
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("case1:\t" + tl.get());
				System.out.println("inherit case1:\t" + itl.get());
			}
		}).start();
		
	}
	
	static void case2() {
		ThreadLocal<String> tl = new ThreadLocal<>();
		tl.set("case2");
		
		new Thread(new ITLRunnable(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("case2:\t" + tl.get());
			}
		})).start();
	}
	
	static void case3() {
		ThreadLocal<String> tl = new ThreadLocal<>();
		tl.set("case3");
		
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		Future<String> future = executorService.submit(new ITLCallable<String>(new Callable<String>() {
			
			@Override
			public String call() {
				System.out.println("case3:\t" + tl.get());
				return tl.get();
			}
		}));
		try {
			future.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		executorService.shutdown();
	}
	
	static class ITLRunnable implements Runnable {

		private Runnable target;
		private Object threadLocals;
		
		public ITLRunnable(Runnable target) {
			this.target = target;

			try 
			{
				//创建该Runnable的线程为当前线程，复制当前线程的threadLocals信息
				Field field = Thread.class.getDeclaredField("threadLocals");
				field.setAccessible(true);
				threadLocals = field.get(Thread.currentThread());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			
			if (threadLocals != null)
			{
				try {
					//将父线程的threadLocals信息赋值给当前线程
					Field field = Thread.class.getDeclaredField("threadLocals");
					field.setAccessible(true);
					field.set(Thread.currentThread(), threadLocals);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			target.run();
		}
		
	}
	
	static class ITLCallable<T> implements Callable<T> {

		private Callable<T> target;
		private Object threadLocals;
		
		public ITLCallable(Callable<T> callable) {
			this.target = callable;
			try 
			{
				//创建该Runnable的线程为当前线程，复制当前线程的threadLocals信息
				Field field = Thread.class.getDeclaredField("threadLocals");
				field.setAccessible(true);
				threadLocals = field.get(Thread.currentThread());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public T call() throws Exception {
			if (threadLocals != null)
			{
				try {
					//将父线程的threadLocals信息赋值给当前线程
					Field field = Thread.class.getDeclaredField("threadLocals");
					field.setAccessible(true);
					field.set(Thread.currentThread(), threadLocals);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return target.call();
		}
		
	}
	
}
