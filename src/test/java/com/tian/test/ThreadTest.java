package com.tian.test;

public class ThreadTest {

	class RunnableImp implements Runnable {

		@Override
		public void run() {
			System.out.println("implement runnable");
		}
	}
	
	public static void main(String[] args) {
		RunnableImp runnableImp = new ThreadTest().new RunnableImp();
		Thread th = new Thread(runnableImp);
		th.start();
	}
}
