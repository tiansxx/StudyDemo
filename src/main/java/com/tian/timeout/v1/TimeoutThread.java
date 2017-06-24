package com.tian.timeout.v1;

/**
 * 
 * @author tian
 */

public class TimeoutThread extends Thread {

	private long timeout;
	
	private volatile boolean cancel;
	
	public TimeoutThread(long timeout) {
		this.timeout = timeout;
	}
	
	@Override
	public void run() {
		
		try {
			Thread.sleep(timeout);
			//
			if (!cancel) {
				throw new TimeoutException("任务执行时间超时");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void cancel() {
		this.cancel = true;
	}
}
