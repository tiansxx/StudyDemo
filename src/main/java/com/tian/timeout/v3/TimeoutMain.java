package com.tian.timeout.v3;

public class TimeoutMain {

	public static void main(String[] args) {
		
		TimeTask task = new TimeTask();
		
		Thread targetTask = new Thread(task);
		TimeoutScanThread scanThread = new TimeoutScanThread(targetTask, 2000);
		targetTask.start();
		scanThread.start();
		
	}
}
