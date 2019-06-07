package com.tian.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class LinkedHashSetMain {
	
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		list.add("f");
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("e");
		list.add("d");
		
		Set<String> s1 = new LinkedHashSet<>();
		s1.addAll(list);
		System.out.println(s1);
		
		Set<String> s2 = new HashSet<>();
		s2.addAll(list);
		System.out.println(s2);
	}
}
