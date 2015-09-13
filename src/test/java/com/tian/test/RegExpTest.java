package com.tian.test;

/**
 * 正则表达式 Regular Expression
 * @author lenovo
 *
 */

public class RegExpTest {
	
	public static void main(String[] args) {
		
		String s = "dfafaga";
		
		System.out.println(s.matches("[a-zA-Z]*"));
		System.out.println(s.matches("\\w*") + "\t" + s.matches("(\\w*[^0-9])"));
		System.out.println(s.matches("^d.*"));
		System.out.println(s.matches(".*a$"));
		System.out.println(s.matches("[\\w&&[^0-9]]+"));
		System.out.println(s.matches("[\\w&&[^\\d]]+"));
		System.out.println(s.matches("[\\w&&\\D]+"));
		System.out.println("=====================");
		
		String s1 = "[]";
		System.out.println(s1.matches("\\[\\]"));
		
		System.out.println("=====================");
		String ip = "192.168.1.121";
		System.out.println(ip.matches("(\\d{1,3}\\.){3}\\d{1,3}"));
//		192...1
		System.out.println(ip.matches("\\d{1,3}\\.{3}\\d{1,3}"));
		
	}

}
