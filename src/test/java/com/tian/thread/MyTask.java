package com.tian.thread;

public class MyTask implements Runnable {

	private static int count = 0;
	
	@Override
	public void run() {
		System.out.println("MyTask " + (++count));
	}
	
	public static void main(String[] args) {
		MyTask task = new MyTask();
		
		for (int i = 0; i < 10; i++) {
			new Thread(task).start();
		}
		
		Thread thread = new Thread();
		thread.start();
		System.out.println(thread.getState());
//		thread.start();
	}

}
