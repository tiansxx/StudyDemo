package com.tian.inher;

public class Father {

	String name = "father";
	
	public Father() {
		System.out.println("#########################");
		System.out.println(this);
		System.out.println(this.name);
		print();
		System.out.println("#########################");
	}
	
	void print() {
		System.out.println("father print");
	}
}
