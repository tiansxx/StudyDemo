package com.tian.timeout.v2;

import java.util.concurrent.Callable;

/**
 * 
 * @author tian
 */

public class TimeTask implements Callable<String> {

	@Override
	public String call() throws Exception {
		Thread.sleep(1000);
		return "Time task exec finished.";
	}

}
