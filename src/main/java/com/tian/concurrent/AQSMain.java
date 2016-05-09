package com.tian.concurrent;

import java.util.concurrent.CountDownLatch;

public class AQSMain {

	public static void main(String[] args) {
		CountDownLatch countDown = new CountDownLatch(3);
		countDown(countDown);
		try {
//			主线程会阻塞到CountDownLatch减为0时await()返回,"over" 才输出
			countDown.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("over");
		
	}
	
	public static void countDown(CountDownLatch count) {
		Task t1 = new Task("t1", count);
		Task t2 = new Task("t2", count);
		Task t3 = new Task("t3", count);
		new Thread(t1).start();
		new Thread(t2).start();
		new Thread(t3).start();
		
	}
	
	private static class Task implements Runnable {
		
		private String name;
		private CountDownLatch count;
		
		public Task(String name, CountDownLatch count) {
			this.name = name;
			this.count = count;
		}
		
		@Override
		public void run() {
			System.out.println(name);
			count.countDown();
		}
		
	}
	
}
