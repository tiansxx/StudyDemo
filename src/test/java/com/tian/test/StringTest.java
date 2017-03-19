package com.tian.test;

import java.util.Arrays;

public class StringTest {
	
	public static void main(String[] args) {
		
		String s = "\r\n";
		System.out.println(s.length());
		System.out.println("".equals(s));
		System.out.println(null == s);
		System.out.println("\r\n".equals(s));
		
		String str = "$$a$$$$b";
		String[] sa = str.split("\\$\\$");
		System.out.println(Arrays.deepToString(sa));
		
	}
	
	static void append() {
		StringBuilder sb = new StringBuilder("hello");
		sb.append("world");
		System.out.println(sb);
	}

}
