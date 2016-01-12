package com.tian.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式 Regular Expression
 * @author lenovo
 *
 */

public class RegExpTest {
	
	public static void main(String[] args) {
		
		/*
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
		*/
		match();
		
	}
	
	static void match() {
		String text = "KiB Mem :   501400 total,    53256 free,   265144 used,   183000 buff/cache" +
					  "KiB Swap:   839676 total,   775016 free,    64660 used.   105816 avail Mem" +
					  "PID USER      PR  NI    VIRT    RES    SHR S %CPU %MEM     TIME+ COMMAND";
//		String exp = "KiB Mem\\s(.*):\\s(.*)\\stotal,\\s(.*)\\sfree,\\s(.*)\\sused,\\s(.*)\\sbuff\\s";
		String exp = "(KiB )?Mem(\\s)?:\\s(.*)\\stotal,\\s(.*)\\sfree,\\s(.*)\\sused,\\s(.*)";
		Pattern pattern = Pattern.compile(exp);
		Matcher matcher = pattern.matcher(text);
		System.out.println("matches()\t" + matcher.matches());
		System.out.println("find()\t" + matcher.find());
		if (matcher.matches()) {
			System.out.println(matcher.groupCount());
//			System.out.println(matcher.group(0));
//			System.out.println(matcher.group(1));
//			System.out.println(matcher.group(2));
//			System.out.println(matcher.group(3));
			System.out.println(matcher.group(4));
			System.out.println(matcher.group(5));
//			System.out.println(matcher.group(6));
		}  
	}

}
