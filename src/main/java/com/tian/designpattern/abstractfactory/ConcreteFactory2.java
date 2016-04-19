package com.tian.designpattern.abstractfactory;

public class ConcreteFactory2 implements AbstractFactory {

	@Override
	public ProductA createA() {
		return new ProductA2();
	}

	@Override
	public ProductB createB() {
		return null;
	}

}
