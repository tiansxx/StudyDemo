package com.tian.enums;

public enum EnumType {

	LENOVO("XiaoXin", "4399"),
	HP("WSAD", "5799"),
	THINKPAD("E460", "5399");
	
	private String name;
	private String price;
	
//	enum不支持public和protected修饰的构造方法，一定要用private的
	private EnumType(String name, String price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getPrice() {
		return this.price;
	}
	
}
