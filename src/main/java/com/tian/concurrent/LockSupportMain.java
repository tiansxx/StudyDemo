package com.tian.concurrent;

import java.util.concurrent.locks.LockSupport;

public class LockSupportMain {

	public static void main(String[] args) {
		
		System.out.println("start");
//		如果许可未被占用,则方法立即返回,否则阻塞当前线程;许可默认被占用
//		LockSupport不可重入,如果同一线程2次调用该park方法将被阻塞
		LockSupport.park();
		System.out.println("end");
		
	}
	
}
