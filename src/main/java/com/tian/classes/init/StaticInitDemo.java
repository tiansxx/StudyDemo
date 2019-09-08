package com.tian.classes.init;

public class StaticInitDemo {

	public static void main(String[] args) {
		
//		Top.staticBottom();
		
		Top.staticTop();
		
	}
}

class Bottom {
	
	static {
		System.out.println("bottom");
	}
	
	public static void staticBottom() {
		System.out.println("static bottom method.");
	}
}

class Top extends Bottom {
	
	static {
		System.out.println("top");
	}
	
	public static void staticTop() {
		System.out.println("static top method.");
	}
	
}
