package com.tian.thread.test;

public class ThreadStateTest {
	
	public static void main(String[] args) {
//		new ThreadStateTest().blocked();
		System.out.println(System.getProperty("java.io.tmpdir"));
		while(true) {}
	}
	
	
	public void waiting() {
		
	}
	
	
	public void timed_waiting() {
		
	}
	
	
	public void blocked() {
		EntryMonitorSet monitor = new EntryMonitorSet();
		TaskUsedForThreadState t1 = new TaskUsedForThreadState(monitor);
		TaskUsedForThreadState t2 = new TaskUsedForThreadState(monitor);
		Thread th1 = new Thread(t1, "ThreadState###1");
		Thread th2 = new Thread(t2, "ThreadState###2");
		th1.start();
		th2.start();
	}
	
	
	public void runnable() {
		
	}
	
}

class TaskUsedForThreadState implements Runnable {
	
	private EntryMonitorSet flag;
	
	public TaskUsedForThreadState(EntryMonitorSet flag) {
		this.flag = flag;
	}

	@Override
	public void run() {
		flag.entry();
	}
}

class EntryMonitorSet {
	
	private Object obj = new Object();
	
	public void entry() {
		synchronized (obj) {
//			blocked
//			while (true) {}
			
//			timed_waiting
			try {
				Thread.sleep(100000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
