package com.tian.designpattern.singleton;

/**
 * 
 * 单例模式-懒汉式改进
 * 
 * @author tian
 */

public class SingletonPattern3 {

	private static Singleton instance;
	
	/**
	 * 获取单例对象时都加锁, 顺序获取单例对象
	 * @return
	 */
	public static synchronized Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
}
