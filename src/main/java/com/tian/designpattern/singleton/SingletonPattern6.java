package com.tian.designpattern.singleton;

/**
 * 
 * jvm机制保证枚举类的线程安全、反射安全和反序列化安全
 * 
 * @author tian
 */

public enum SingletonPattern6 {
	
	INSTANCE;
	
	public static SingletonPattern6 getInstance()
	{
		return INSTANCE;
	}
	
	public static void main(String[] args) {
		System.out.println(SingletonPattern6.getInstance());
		System.out.println(SingletonPattern6.getInstance().name());
		System.out.println(SingletonPattern6.getInstance().getClass());
	}
	
}
