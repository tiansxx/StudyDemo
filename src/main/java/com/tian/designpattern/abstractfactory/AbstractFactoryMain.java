package com.tian.designpattern.abstractfactory;


/**
 * 
 * @author tian
 * 
 * 抽象工厂模式:对修改关闭,对扩展打开
 * 
 * 1.创建工厂接口和产品接口
 * 2.实现工厂接口,创建相应的产品
 * 3.如果有新的产品添加进来,创建新的工厂用于创建产品
 * 
 */

public class AbstractFactoryMain {

	public static void main(String[] args) {
		AbstractFactory afac1 = new ConcreteFactory1();
		afac1.createA();
		
		AbstractFactory afac2 = new ConcreteFactory2();
		afac2.createA();
	}
	
}
