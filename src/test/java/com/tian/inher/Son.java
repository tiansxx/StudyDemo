package com.tian.inher;

public class Son extends Father {
	
	String name = "son";
	
	public Son() {
		System.out.println("+++++++++++++++++++++++++");
		System.out.println(this);
		System.out.println(this.name);
		print();
		System.out.println("+++++++++++++++++++++++++");
	}
	
	void print() {
		System.out.println("son print");
	}
	
	public static void main(String[] args) {
		new Son();
	}

}
