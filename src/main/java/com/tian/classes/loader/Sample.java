package com.tian.classes.loader;

public class Sample {
	
	public static void main(String[] args) {
		
		Sample s1 = new Sample();
		
		MyClassLoader myClassLoader = new MyClassLoader();
		try {
			Sample s2 = (Sample) myClassLoader.loadClass("com.tian.classes.loader.Sample").newInstance();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
