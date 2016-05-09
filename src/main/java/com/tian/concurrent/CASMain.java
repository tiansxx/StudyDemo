package com.tian.concurrent;

/**
 * Compare and Swap
 * 
 * @author tian
 *
 */

public class CASMain {

	private int count;

	public synchronized int compareAndSet(int except, int update) {
		int oldValue = count;
		if (oldValue == except) {
			count = update;
		}
		return oldValue;
	}

	public int increase() {
		int v;
		do{
			v = count;
		}while(v != compareAndSet(v, v + 1));
		return v + 1;
	}

}
