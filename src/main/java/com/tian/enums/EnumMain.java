package com.tian.enums;

public class EnumMain {

	//	private static enum Type {LENOVO, DELL, HP, THINKPAD}

	public static void main(String[] args) {
		EnumMain enumMain = new EnumMain();
		enumMain.stateMachine();
	}
	
	public void stateMachine() {
		States.NEW.process(States.BLOCKED);
	}

	public void basic() {
		EnumType type = EnumType.LENOVO;

		System.out.println(type);
		System.out.println(type.toString());
		System.out.println(type.getName() + "\t" + type.getPrice());

		System.out.println("============================");
		for (EnumType t : EnumType.values()) {
			System.out.println(t);
		}

		//		System.out.println(Type.LENOVO);
		//		for (Type t : Type.values()) {
		//			System.out.println(t);
		//		}
	}
}
