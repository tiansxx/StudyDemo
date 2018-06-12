package com.tian.timeout.v3;

public class TimeoutScanThread extends Thread {
	
	private Thread task;
	private int timeout;
	
	public TimeoutScanThread(Thread task, int timeout)
	{
		this.task = task;
		this.timeout = timeout;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		task.interrupt();
	}
	
}
