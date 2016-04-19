package com.tian.designpattern.adapter;

/**
 * 
 * @author tian
 * 
 * 适配器模式:
 * Adapter 适配器,转换操作
 * 
 * Adaptee 实际操作执行者
 * 
 * Target  客户端直接操作的对象,通过Adapter适配到Adaptee
 * 
 * 
 */

public class AdapterMain {
	public static void main(String[] args) {
		
		Adaptee adaptee = new ConcreteAdaptee();
		Target target = new Adapter(adaptee);
		
		target.process();
		
	}
}
