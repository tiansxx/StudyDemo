package com.tian.proxy;

public class HelloImpl implements Hello {

	@Override
	public void hello() {
		System.out.println("Hello World");
	}

	@Override
	public Object hello(String s) {
		return "Hello " + s;
	}


}
