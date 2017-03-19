package com.tian.shutdown;

import java.util.concurrent.TimeUnit;

/**
 * 
 * @author tian
 */

public class ShutdownHook implements Runnable {

	@Override
	public void run() {
		System.out.println("CurrentTime: " + System.currentTimeMillis());
		try {
			TimeUnit.SECONDS.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("ShutdownTime: " + System.currentTimeMillis());
	}

}
