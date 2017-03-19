package com.tian.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author tian
 */

public class GenericTest {

	public static void main(String[] args) {
		
		List<? extends Fruit> l1 = new ArrayList<>();
		l1.get(0);
		
		List<? super Fruit> l2 = new ArrayList<>();
		l2.add(new Apple());
		l2.add(new Orange());
	}
	
}
