package com.tian.designpattern.singleton;

/**
 * 
 * @author tian
 */

public class SingletonPattern4 {

	private static volatile Singleton instance;
	
	/**
	 * 双重校验锁
	 * 只在有必要时才加锁, 较少加锁的次数
	 * volatile保证实例在多线程间的可见性
	 * 
	 * @return
	 */
	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (SingletonPattern3.class) {
				if (instance == null)
					instance = new Singleton();
			}
		}
		return instance;
	}
	
}
