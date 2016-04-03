package com.tian.collection.test;

import java.util.ArrayList;
import java.util.List;

public class GenericTypeTest {

	
	public static void main(String[] args) {
		
		List<String> ls = new ArrayList<>();
		unsafeAdd(ls, "s");
		
	}
	
	
	static <E> void unsafeAdd(List<E> lo, E o) {
		lo.add(o);
		@SuppressWarnings({ "unchecked", "unused" })
		E[] e = (E[])(new Object[10]);
		
		@SuppressWarnings({ "unchecked", "unused" })
		E eo = (E)(new Object());
	}
	
}
