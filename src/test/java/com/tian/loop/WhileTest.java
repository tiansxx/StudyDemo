package com.tian.loop;

public class WhileTest {
	
	public static void main(String[] args) {
		String s = "a";
		
		out:
		while (true)
		{
			switch (s) {
			case "a":
				System.out.println("a");
				break out;
			case "b":
				System.out.println("b");
				break;
			default:
				System.out.println("default");
				break;
			}
		}
		System.out.println("out");
		
	}

}
