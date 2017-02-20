package com.tian.designpattern.singleton;

/**
 * 单例模式-懒汉式
 * 优点:
 * 需要使用时才初始化单例
 * 
 * 缺陷:
 * 不是线程安全的,并发情况下,可能获得多个对象实例
 * 
 * @author tian
 */

public class SingletonPattern1 {
	
	private static Singleton instance;
	
	public static Singleton getInstance() {
		if (instance == null)
		{
			instance = new Singleton();
		}
		return instance;
	}
	
	
}
