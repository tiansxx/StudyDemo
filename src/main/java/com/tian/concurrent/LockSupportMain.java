package com.tian.concurrent;

import java.util.concurrent.locks.LockSupport;

public class LockSupportMain {

	public static void main(String[] args) {
		System.out.println("LockSupport start.");
		parkOther();
		parkSelf();
		System.out.println("LockSupport end.");
	}

	private static void parkSelf() {
		System.out.println("start");
//		如果许可未被占用,则方法立即返回,否则阻塞当前线程;许可默认被占用
//		LockSupport不可重入,如果同一线程2次调用该park方法将被阻塞
		LockSupport.park();
		System.out.println("end");
	}
	
	private static void parkOther() {
		Thread t = new Thread(new Task(), "park other");
		t.start();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		给t线程释放许可
		LockSupport.unpark(t);
	}
	
	private static class Task implements Runnable {

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + " start.");
			
			LockSupport.park();
			
			System.out.println(Thread.currentThread().getName() + " end.");
		}
		
	}
	
	
	
}
