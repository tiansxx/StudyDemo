package com.tian.shutdown;

import sun.misc.Signal;

/**
 * 
 * @author tian
 */

public class ShutdownMain {

	public static void main(String[] args) throws InterruptedException {
		
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
