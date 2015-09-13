package com.tian.thread;

public class Param {
	
	public Param() {
		
	}
	
	public static void main(String[] args) {
		Param p1 = new Param();
		Param p2 = new Param();
		
		MyThread myThread = new MyThread(p1);
		new Thread(myThread).start();
		myThread.setParam(p2);
		new Thread(myThread).start();
	}

}
