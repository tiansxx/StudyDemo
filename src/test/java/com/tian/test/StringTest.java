package com.tian.test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest {
	
	public static void main(String[] args) {
		
		patternSplit();
	}
	
	static void test() {
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
	
	static void patternSplit() {
		
		
		Pattern COMMA_SPLIT_PATTERN = Pattern.compile("\\s*[,]+\\s*");
		
		Matcher matcher = COMMA_SPLIT_PATTERN.matcher("abc,");
		System.out.println(matcher.matches());
		
		System.out.println(Arrays.asList(COMMA_SPLIT_PATTERN.split("abc")));
		System.out.println(Arrays.asList(COMMA_SPLIT_PATTERN.split("abc,abc")));
		System.out.println(Arrays.asList(COMMA_SPLIT_PATTERN.split("abcabc")));
	}

}
