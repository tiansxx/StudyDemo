package com.tian.sync;

/**
 * 
 * @author tian
 */

public class SyncMain implements Runnable {

	private static SyncService sync = new SyncService();
	
	private String msg;
	private boolean syncFirst;
	
	public SyncMain(String msg, boolean syncFirst) {
		this.msg = msg;
		this.syncFirst = syncFirst;
	}
	
	@Override
	public void run() {
		if (syncFirst) {
			sync.syncFirst(msg);
			sync.syncSecond(msg);
		} else {
			sync.syncSecond(msg);
			sync.syncFirst(msg);
		}
	}
	
	public static void main(String[] args) {
		SyncMain s1 = new SyncMain("a", true);
		SyncMain s2 = new SyncMain("b", false);
		new Thread(s1).start();
		new Thread(s2).start();
	}

}
