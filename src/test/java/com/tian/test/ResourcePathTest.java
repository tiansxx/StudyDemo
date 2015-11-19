package com.tian.test;

import java.net.URL;

public class ResourcePathTest {

	public static void main(String[] args) {
		new ResourcePathTest().clPath();
		new ResourcePathTest().path();
	}
	
	void path() {
		URL resource = getClass().getResource("");
		System.out.println(resource);
		URL r2 = getClass().getResource("/");
		System.out.println(r2);
	}
	
	void clPath() {
		URL resource = getClass().getClassLoader().getResource("");
		System.out.println(resource);
	}
}
