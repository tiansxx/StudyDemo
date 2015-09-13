package com.tian.generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author lenovo
 *
 * 泛型
 */

public class GenericsMain {

	public static void main(String[] args) {
		List<Object> ls = new ArrayList<Object>();
		ls.add("1");
		ls.add(1);
//		printList(ls);
	}
	
	static void printList(List<?> list) {
		Iterator<?> iter = list.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	
}
