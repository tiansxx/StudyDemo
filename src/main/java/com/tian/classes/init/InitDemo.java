package com.tian.classes.init;

/**
 * 
 * 
 * 
 * @author tian
 */

public class InitDemo {
	
	static {
		System.out.println("static code init demo");
	}
	
	public InitDemo() {
		System.out.println("init demo.");
	}
	
	public static void main(String[] args) throws Exception {
		init();
	}
	
	public static void classInitialize() throws Exception {
		//调用构造方法,调用静态代码块
		InitDemo.class.newInstance();
		Class.forName("com.tian.classes.init.InitDemo").newInstance();
		//不调用构造方法,调用静态代码块
		Class.forName("com.tian.classes.init.InitDemo", true, ClassLoader.getSystemClassLoader());
		Class.forName("com.tian.classes.init.InitDemo");
		//不调用构造方法,不会类进行初始化,不调用静态代码块
		Class.forName("com.tian.classes.init.InitDemo", false, ClassLoader.getSystemClassLoader());
	}
	
	public static void init() {
		//执行静态代码块,不会初始化静态变量
//		ExtenedDemo.print();
//		ExtenedDemo.print();
		
		//执行静态代码块,且初始化静态变量
//		new ExtenedDemo("test", "testinit");
		
		AbstractParent.print();
		
	}
	
}
