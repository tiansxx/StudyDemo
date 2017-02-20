package com.tian.designpattern.singleton;

/**
 * 
 * 单例模式-饿汉式改进
 * 
 * 利用jvm内部类机制, 只在使用单例时才创建实例
 * 
 * @author tian
 */

public class SingletonPattern5 {

	private static class SingleHolder {
		private static final Singleton instance = new Singleton();
	}
	
	public static Singleton getInstance() {
		return SingleHolder.instance;
	}
	
}
