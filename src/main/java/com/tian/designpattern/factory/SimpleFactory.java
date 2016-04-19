package com.tian.designpattern.factory;

public class SimpleFactory {
	
	public Product createProduct(String type) {
		if ("a".equalsIgnoreCase(type)) {
			return new ProductA();
		} else if ("b".equalsIgnoreCase(type)) {
			return new ProductB();
		}
		return null;
	}
}
