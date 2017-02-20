package com.tian.designpattern.singleton;

/**
 * 单例模式-饿汉式
 * 优点：
 * 线程安全
 * 
 * 缺陷：
 * 类初始化时即初始化单例, 有可能外部仅仅是调用该类的其他静态变量,并没有用到该单例,造成资源浪费
 * 
 * @author tian
 */

public class SingletonPattern2 {

	private static Singleton instance = new Singleton();
	
	public static Singleton getInstance() {
		return instance;
	}
	
}
