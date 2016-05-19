package com.tian.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchThreadJoin {

	public static void main(String[] args) throws InterruptedException {

//		threadJoin();
		countDownLatch();
		System.out.println("over");

	}

	public static void countDownLatch() {

		CountDownLatch l = new CountDownLatch(3);
		
		Thread th1 = new Thread(new SimpleTask("t1", l));
		Thread th2 = new Thread(new SimpleTask("t2", l));
		Thread th3 = new Thread(new SimpleTask("t3", l));
		
		th1.start();
		th2.start();
		th3.start();
		
		try {
			l.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void threadJoin() throws InterruptedException {
		Thread th1 = new Thread(new Task("t1"));
		Thread th2 = new Thread(new Task("t2"));
		Thread th3 = new Thread(new Task("t3"));

		th1.start();
		th2.start();
		th3.start();

		th1.join();
		th2.join();
		th3.join();
	}

	private static class Task implements Runnable {

		private String name;

		public Task(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			System.out.println(name);
		}
	}
	
	private static class SimpleTask extends Task {

		private CountDownLatch l;
		
		public SimpleTask(String name, CountDownLatch l) {
			super(name);
			this.l = l;
		}
		
		@Override
		public void run() {
			super.run();
			l.countDown();
		}
		
	}

}
