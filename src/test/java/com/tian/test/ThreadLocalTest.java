package com.tian.test;

public class ThreadLocalTest {
	
	private static ThreadLocal<Integer> threadCount = new ThreadLocal<Integer>() {
		protected Integer initialValue() {
			return 0;
		};
		
//		public Integer nextCount() {
//			threadCount.set(threadCount.get() + 1);
//			return threadCount.get();
//		}
	};
	
	public static class Task extends Thread {
		String name;
		
		public Task(String name) {
			this.name = name;
		}
 		
		@Override
		public void run() {
			System.out.println(threadCount.get());
		}
		
	}
	
	public static void main(String[] args) {
		Task t1 = new Task("t1");
		Task t2 = new Task("t2");
		t1.start();
		t2.start();
	}
}
