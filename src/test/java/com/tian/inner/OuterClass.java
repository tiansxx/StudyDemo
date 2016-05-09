package com.tian.inner;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author lenovo
 * 内部类的正确使用姿势
 *
 */

public class OuterClass {

	private List<String> list = new ArrayList<>();
	
	{
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
	}
	
	public InnerClass inner() {
		return new InnerClass();
	}
	
	private class InnerClass {
		
		private int MAX_LENGTH = list.size();
		private int position = 0;
		
		public String next() {
			if (position < MAX_LENGTH) {
				return list.get(position++);
			}
			return "End Of List";
		}
		
		public boolean hasNext() {
			return position < MAX_LENGTH;
		}
		
	}
	
	private static class StaticInnerClass {
		
	}
	
	public static void main(String[] args) {
		OuterClass outerClass = new OuterClass();
		InnerClass inner = outerClass.inner();
		while (inner.hasNext()) {
			System.out.println(inner.next());
		}
		
		new StaticInnerClass();
		
	}
	
}
