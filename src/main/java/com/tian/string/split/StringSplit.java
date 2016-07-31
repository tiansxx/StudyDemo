package com.tian.string.split;

import java.util.StringTokenizer;

/**
 * 
 * StringTokenizer	默认对2个分隔符之间的空格不返回
 * String.split		默认返回2个分割符之间的空格
 * 
 * @author tian
 *
 */

public class StringSplit {

	public static void main(String[] args) {
		String delims = ",";
		String s = "one,two,,three,four,,five";
		tokenizer(s, delims);
		split(s, delims);
	}
	
	/**
	 * @param s			原始字符串
	 * @param delim		分隔符	delimiter
	 */
	public static void tokenizer(String s, String delim) {
		StringTokenizer st = new StringTokenizer(s, delim);
		while (st.hasMoreTokens()) {
			System.out.println("StringTokenizer : " + st.nextToken());
		}
	}
	
	public static void split(String s, String delim) {
		String[] ss = s.split(delim);
		for (int i = 0; i < ss.length; i++) {
			System.out.println("Split : " + ss[i]);
		}
	}
	
}
