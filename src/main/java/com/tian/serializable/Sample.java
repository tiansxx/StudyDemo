package com.tian.serializable;

import java.io.Serializable;

/**
 * 
 * @author tian
 */

public class Sample implements Serializable {

	private static final long serialVersionUID = -6332136531825618880L;

	private String name;
	
	private String desc;
	
//	private String ext;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Sample [name=" + name + ", desc=" + desc + "]";
	}
	
//	public String getExt() {
//		return ext;
//	}
//
//	public void setExt(String ext) {
//		this.ext = ext;
//	}
}
