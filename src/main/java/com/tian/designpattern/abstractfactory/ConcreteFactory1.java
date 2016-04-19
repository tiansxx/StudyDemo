package com.tian.designpattern.abstractfactory;

public class ConcreteFactory1 implements AbstractFactory {

	@Override
	public ProductA createA() {
		return new ProductA1();
	}

	@Override
	public ProductB createB() {
		return null;
	}

}
