package com.tian.concurrent;


public class ThreadJoin {

	public static void main(String[] args) throws InterruptedException {
		Thread th1 = new Thread(new Task("t1"));
		Thread th2 = new Thread(new Task("t2"));
		Thread th3 = new Thread(new Task("t3"));
		
		th1.start();
		th2.start();
		th3.start();
		
		th1.join();
		th2.join();
		th3.join();
		
		System.out.println("over");
		
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
	
}
