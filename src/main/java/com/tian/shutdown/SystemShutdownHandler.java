package com.tian.shutdown;

import sun.misc.Signal;
import sun.misc.SignalHandler;

/**
 * 
 * @author tian
 */

public class SystemShutdownHandler implements SignalHandler {

	@Override
	public void handle(Signal signal) {
		invokeShutdownHook();
	}
	
	private void invokeShutdownHook() {
		Thread thread = new Thread(new ShutdownHook(), "Shutdown-Hook Thread");
		Runtime.getRuntime().addShutdownHook(thread);
	}


}
