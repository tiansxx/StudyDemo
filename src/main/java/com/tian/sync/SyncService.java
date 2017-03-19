package com.tian.sync;

/**
 * 
 * @author tian
 */

public class SyncService {
	
	public synchronized void syncFirst(String msg) {
		System.out.println("first\t" + Thread.currentThread().getName() + "\t" + msg);
	}
	
	public synchronized void syncSecond(String msg) {
		System.out.println("second\t" + Thread.currentThread().getName() + "\t" + msg);
	}
	
}
