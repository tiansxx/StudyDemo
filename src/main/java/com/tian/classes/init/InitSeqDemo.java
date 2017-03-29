package com.tian.classes.init;

/**
 * 
 * @author tian
 */

public class InitSeqDemo {

	private Integer i;
	
	
	public InitSeqDemo() {
		System.out.println(i);
	}

	{
		i = 2;
	}
	
	
	public static void main(String[] args) {
		new InitSeqDemo();
	}
	
}
