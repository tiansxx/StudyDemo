package com.tian.spi;

public class SimpleServiceImpl implements SimpleService {

	@Override
	public void say(String s) {
		System.out.println("hello spi, " + s);
	}

}
