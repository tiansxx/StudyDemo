package com.tian.classes.init;

/**
 * 
 * @author tian
 */

public class ExtenedDemo extends AbstractParent {

	private String msg;
	
	static {
		System.out.println("static ExtenedDemo");
	}
	
	public ExtenedDemo(String msg, String desc) {
		super(desc);
		this.msg = msg;
		System.out.println("constructor msg: " + this.msg);
	}
	
	public static final ExtenedDemo INIT = new ExtenedDemo("init", "static");
	
	public static void main(String[] args) {
		ExtenedDemo.print();
	}

	@Override
	public String toString() {
		return "ExtenedDemo [msg=" + msg + "]";
	}
}
