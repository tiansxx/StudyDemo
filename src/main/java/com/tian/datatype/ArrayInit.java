package com.tian.datatype;

public class ArrayInit {

	public static void main(String[] args) {
		
		char[] chs = new char[3];
		for (int i = 0; i < chs.length; i++) {
			System.out.println(chs[i] + "" + ('\u0000' == chs[i]));
		}
		
		String[] ss = new String[3];
		for (int i = 0; i < ss.length; i++) {
			System.out.println(ss[i]);
		}
	}
}
