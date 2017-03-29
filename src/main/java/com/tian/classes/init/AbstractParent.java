package com.tian.classes.init;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author tian
 */

public abstract class AbstractParent {
	
	private String desc;
	
	static {
		System.out.println("static parent");
	}
	
	private static final Map<String, AbstractParent> codeMap = new HashMap<>();
	
	public AbstractParent(String desc) {
		this.desc = desc;
		System.out.println("constructor parent desc: " + this.desc);
		codeMap.put(desc, this);
	}
	
	public static void print() {
		System.err.println("map: " + codeMap);
	}
	
}
