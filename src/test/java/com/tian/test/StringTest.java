package com.tian.test;

public class StringTest {
	
	public static void main(String[] args) {
		
		String s = "\r\n";
		System.out.println(s.length());
		System.out.println("".equals(s));
		System.out.println(null == s);
		System.out.println("\r\n".equals(s));
		
	}
	
	static void append() {
		StringBuilder sb = new StringBuilder("hello");
		sb.append("world");
		System.out.println(sb);
	}

}
