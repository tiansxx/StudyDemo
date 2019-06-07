package com.tian.shutdown;

import sun.misc.Signal;

/**
 * 
 * @author tian
 */

public class ShutdownMain {

	public static void main(String[] args) {
		
		shutdownPending();
		
	}
	
	static void shutdownPending() {
		
		Thread thread = new Thread(new ShutdownHook(), "Shutdown-Hook Thread");
		Runtime.getRuntime().addShutdownHook(thread);
		
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.exit(0);
		
	}
	
	static void signalShutdown() throws InterruptedException {
		Signal signal = new Signal(getOsSignalType());
		Signal.handle(signal, new SystemShutdownHandler());
		Object o = new Object();
		synchronized (o) {
			o.wait(3000);
		}
		System.exit(0);
	}
	
	public static String getOsSignalType() {
		return System.getProperty("os.name").toLowerCase().startsWith("win") ? "INT" : "USR2";
	}
}
