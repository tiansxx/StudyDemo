package com.tian.collection;

import java.util.ArrayList;
import java.util.List;

public class ListMain {

	public static void main(String[] args) {
		
		List<ListElement> list = new ArrayList<>();
		
		ListElement le;
		for (int i = 0; i < 5; i++) {
			le = new ListElement();
			le.setName("name_" + i);
			list.add(le);
		}
		
		System.out.println(list);
		
	}
	
}
