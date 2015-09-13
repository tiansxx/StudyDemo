package com.tian.thread;

public class MyThread implements Runnable {
	
	private int i; 
	private Param param;
	
	public MyThread(Param param) {
		this.param = param;
	}
	
	public void setParam(Param param) {
		this.param = param;
	}
	
	@Override
	public synchronized void run() {
		System.out.println(param + " " + i);
		i++;
	}

}
