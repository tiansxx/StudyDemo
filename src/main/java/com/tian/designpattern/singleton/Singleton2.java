package com.tian.designpattern.singleton;

import java.io.Serializable;

/**
 * 
 * 当单例类实现了序列化接口时
 * 对象反序列化默认会创建新的对象, 破坏单例
 * 重写readResolve可解决该问题
 * 
 * 反序列化机制:
 * 实现了serializable或者externalizable接口的类中又包含readResolve方法时，会调用该方法获取实例
 * 
 * @author tian
 */

public class Singleton2 implements Serializable {
	
	private static final long serialVersionUID = -5085140196357753839L;
	
	private static final class SingletonHolder {
		private static final Singleton2 instance = new Singleton2();
	}
	
	public static Singleton2 getInstance()
	{
		return SingletonHolder.instance;
	}
	
	private Object readResolve() {
		return SingletonHolder.instance;
	}

}
