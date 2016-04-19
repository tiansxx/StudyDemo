package com.tian.designpattern.adapter;

public class ConcreteAdaptee implements Adaptee {

	@Override
	public void print() {
		System.out.println("adaptee print.");
	}

}
