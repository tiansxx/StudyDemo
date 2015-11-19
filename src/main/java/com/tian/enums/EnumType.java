package com.tian.enums;

public enum EnumType {

	eBay("ebay"),
	NetEase("netease"),
	Alibaba("alibaba");
	
	private String name;
	
	private EnumType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
}
