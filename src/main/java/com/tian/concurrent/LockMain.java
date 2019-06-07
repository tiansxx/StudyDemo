package com.tian.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockMain {
	
	static Lock lock = new ReentrantLock();
	static Condition condition = lock.newCondition();
	
	
	public static void main(String[] args) throws InterruptedException {
		
		new Thread(new WaitTask()).start();
		new Thread(new SignalTask()).start();
		
	}
	
	static class WaitTask implements Runnable {

		@Override
		public void run() {
			try {
				lock.lockInterruptibly();
				
				condition.await();
				System.out.println("behind condition await.");
				
			} catch (Exception e) {
				System.out.println("wait task exception." + e.getMessage());
				e.printStackTrace();
			}finally {
				System.out.println("finally block.");
				lock.unlock();
			}
		}
	}
	
	static class SignalTask implements Runnable {

		@Override
		public void run() {
			
			try {
				
				Thread.sleep(1500);
				
				lock.lockInterruptibly();
				
				
				condition.signalAll();
				
				System.out.println("singal task. ");
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				System.out.println("signal task. finally");
//				lock.unlock();
			}
			
		}
		
	}

}
