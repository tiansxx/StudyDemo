package com.tian.concurrent.test;

/**
 * 
 * 对比同步控制块和同步控制方法
 * 
 * @author tian
 *
 */

public class WaitLoopTest {

//	private Object monitor = new Object();
	private volatile int num = 0;

	public static void main(String[] args) {
		
		final WaitLoopTest waitLoop = new WaitLoopTest();
		
		Runnable task1 = new Runnable() {

			@Override
			public void run() {
				waitLoop.await();
			}
		};
		
		new Thread(task1, "wait loop").start();
		
		Runnable task2 = new Runnable() {

			@Override
			public void run() {
				waitLoop.getAndIncrement();
			}
		};
		new Thread(task2).start();
	}

	public synchronized void await() {
		System.out.println(Thread.currentThread().getName());
//		synchronized (monitor) {
			while (num < 2)
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
//		}
		System.out.println("num = " + num);
	}
	
	public synchronized void getAndIncrement() {
//		synchronized (monitor) {
			this.num = this.num + 1;
			this.notify();
//			monitor.notify();
//		}
	}
	
}
