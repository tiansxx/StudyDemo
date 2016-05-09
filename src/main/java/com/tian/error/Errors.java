package com.tian.error;

import java.util.ArrayList;
import java.util.List;

public class Errors {
	
	static int num = 0;
	
	public static void main(String[] args) {
//		outOfMemoryError();
//		outOfMemoryError2();
		outOfMemoryError3();
//		stackOverflowError();
	}
	
	public static void outOfMemoryError() {
//		java.lang.OutOfMemoryError: Requested array size exceeds VM limit
//		依赖于虚拟机实现,在ArrayList中有MAX_ARRAY_SIZE的说明,但具体的长度限制有所不同
		byte[] bs = new byte[Integer.MAX_VALUE];

//		数组允许的最大长度为(Integer.MAX_VALUE - 1)
//		java.lang.OutOfMemoryError: Java heap space
//		byte[] bs2 = new byte[Integer.MAX_VALUE - 1];	
	}
	
//	java.lang.OutOfMemoryError: Java heap space
	public static void outOfMemoryError2() {
		List<int[]> l = new ArrayList<>();
		while (true) {
			int[] is = new int[100000];
			l.add(is);
		}
	}
	
//	java.lang.OutOfMemoryError: PermGen space		???
	public static void outOfMemoryError3() {
		List<String> list = new ArrayList<String>();
		int i = 0;
		String s = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
		while(true){
			list.add(( s + (i++)).intern());
		}
	}
	
//	12551
	public static void stackOverflowError() {
		System.out.println(num++);
		stackOverflowError();
	}

}
