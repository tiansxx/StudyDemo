package com.tian.timeout.v1;

/**
 * 
 * @author tian
 */

public class TaskThread extends Thread {

	private TimeoutThread timeoutThread;
	
	private String threadName;
	
	public TaskThread(String name, TimeoutThread timeoutThread) {
		super(name);
		this.threadName = name;
		this.setDaemon(true); //如果非守护线程退出,则守护线程也退出
		this.timeoutThread = timeoutThread;
	}
	
	public void run() {
		try {
			timeoutThread.start();
			Thread.sleep(2000);
			System.out.println(threadName + " exec finished.");
			timeoutThread.cancel();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
