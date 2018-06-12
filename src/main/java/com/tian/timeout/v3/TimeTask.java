package com.tian.timeout.v3;


/**
 * 
 * @author tian
 */

public class TimeTask implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
			System.out.println("Task exec finished.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
