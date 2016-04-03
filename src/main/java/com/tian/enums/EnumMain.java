package com.tian.enums;

public class EnumMain {
	
//	private static enum Type {LENOVO, DELL, HP, THINKPAD}

	public static void main(String[] args) {
		EnumType type = EnumType.LENOVO;
		
		System.out.println(type);
		System.out.println(type.toString());
		System.out.println(type.getName() + "\t" + type.getPrice());
		
		System.out.println("=============================");
		for (EnumType t : EnumType.values()) {
			System.out.println(t);
		}
		
//		System.out.println(Type.LENOVO);
//		for (Type t : Type.values()) {
//			System.out.println(t);
//		}
	}
}
