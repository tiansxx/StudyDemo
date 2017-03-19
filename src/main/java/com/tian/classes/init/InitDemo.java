package com.tian.classes.init;

/**
 * 
 * @author tian
 */

public class InitDemo {
	
	public InitDemo() {
		System.out.println("init demo.");
	}
	
	public static void main(String[] args) throws Exception {
		//调用构造方法
		InitDemo.class.newInstance();
		
		Class.forName("com.tian.classes.init.InitDemo");
	}
	
}
