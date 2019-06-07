package com.tian.thread.test;

import java.sql.Timestamp;

public class ThreadJoinTest {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new ThreadJoin("A"));
		Thread t2 = new Thread(new ThreadJoin("B"));
		System.out.println("Main Thread =>" + new Timestamp(System.currentTimeMillis()));
		t1.start();
		t1.join();	//调用join(),只有t1执行完后才执行t2
		t2.start();
		t2.join();
		
		System.out.println("main thread end");
		
	}
}

class ThreadJoin implements Runnable {
	
	private String s;
	
	public ThreadJoin(String s) {
		this.s = s;
	}
	
	@Override
	public void run() {
		System.out.println("Thread => " + new Timestamp(System.currentTimeMillis()));
		print();
	}
	
	synchronized void print()
	{
		for (int i = 0; i < 10; i++) {
			System.out.println(s + "\t" + i);
		}
	}
}
