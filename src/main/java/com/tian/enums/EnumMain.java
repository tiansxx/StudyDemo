package com.tian.enums;

public class EnumMain {

	public static void main(String[] args) {
		EnumType type = EnumType.NetEase;
		
		System.out.println(type);
		System.out.println(type.toString());
		System.out.println(type.getName());
		
		for (EnumType t : EnumType.values()) {
			System.out.println(t);
		}
	}
}
