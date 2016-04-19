package com.tian.designpattern.factory;

public class FactoryMain {

	public static void main(String[] args) {
		SimpleFactory fac = new SimpleFactory();
		fac.createProduct("a");
		fac.createProduct("b");
	}
}
