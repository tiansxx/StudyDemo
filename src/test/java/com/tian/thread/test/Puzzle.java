package com.tian.thread.test;

public class Puzzle {
	
	static boolean answerReady = false;
	static int answer = 0;
	static Thread t1 = new Thread() {
		public void run() {
			answer = 1;
			answerReady = true;
		}
	};
	static Thread t2 = new Thread() {
		public void run() {
			if (answerReady) 
				System.out.println("answer : " + answer);
			else 
				System.out.println("I don't know");
		}
	};
	
	
	/**
	 * 编译器的静态优化可以打乱代码的执行顺序
	 * JVM的动态优化也会打乱代码的执行顺序
	 * 硬件可以通过乱序执行来优化其性能 
	 */
	public static void main(String[] args) throws InterruptedException {
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}

}
