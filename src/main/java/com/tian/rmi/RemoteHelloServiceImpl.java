package com.tian.rmi;

public class RemoteHelloServiceImpl implements IHelloService {

	@Override
	public String hello(String s) {
		return "Hello " + s;
	}
	
	@Override
	public void sayHello() {
		System.out.println("Hello RMI");
	}

}
