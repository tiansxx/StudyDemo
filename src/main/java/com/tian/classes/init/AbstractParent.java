package com.tian.classes.init;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author tian
 */

public abstract class AbstractParent {
	
	private String desc;
	private static final Map<String, AbstractParent> codeMap = new HashMap<>();
	
	static {
		System.out.println("static parent");
		try {
			Class.forName("com.tian.classes.init.ExtenedDemo");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public AbstractParent(String desc) {
		this.desc = desc;
		System.out.println("constructor parent desc: " + this.desc);
		codeMap.put(desc, this);
	}
	
	public static void print() {
		System.err.println("map: " + codeMap);
	}
	
}
