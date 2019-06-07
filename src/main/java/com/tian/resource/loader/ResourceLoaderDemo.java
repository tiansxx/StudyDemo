package com.tian.resource.loader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ResourceLoaderDemo {

	public static String resource = "resource.properties";
	
	public static void main(String[] args) {
		load1();
//		load2();
		load3();
		load4();
		load5();
		load6();
		load7();
		load8();
	}
	
	static void load1() {
		InputStream stream = Thread.currentThread().getClass().getResourceAsStream("/" + resource);
		printStream(stream, 1);
	}
	
	static void load2() {
//		InputStream stream = Thread.currentThread().getClass().getResourceAsStream(resource);
		InputStream resourceAsStream = Thread.currentThread().getClass().getClassLoader().getResourceAsStream("/" + resource);
		printStream(resourceAsStream, 2);
	}
	
	static void load3() {
		InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(resource);
		printStream(stream, 3);
	}
	
	static void load4() {
		InputStream stream = ResourceLoaderDemo.class.getResourceAsStream(resource);
		printStream(stream, 4);
	}
	
	static void load5() {
		InputStream resourceAsStream = ResourceLoaderDemo.class.getResourceAsStream("/" + resource);
		printStream(resourceAsStream, 5);
	}
	
	static void load6() {
		InputStream resourceAsStream = ResourceLoaderDemo.class.getClassLoader().getResourceAsStream(resource);
		printStream(resourceAsStream, 6);
	}
	
	static void load7() {
		InputStream resourceAsStream = ClassLoader.getSystemClassLoader().getResourceAsStream(resource);
		printStream(resourceAsStream, 7);
	}
	
	static void load8() {
		InputStream systemResourceAsStream = ClassLoader.getSystemResourceAsStream(resource);
		printStream(systemResourceAsStream, 8);
	}
	
	static void printStream(InputStream resourceAsStream, int i) {
		Properties props = new Properties();
		try {
			props.load(resourceAsStream);
			System.out.println(i + "\t=============== " + props.getProperty("name"));
		} catch (IOException e) {
//			e.printStackTrace();
			System.err.println("******Exception********* " + i);
		}
	}
}
