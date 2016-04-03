package com.tian.serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Name implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;
	
	public Name() {}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
//	使用java默认的序列化方式时，会调用该方法
	private void writeObject(ObjectOutputStream oos) {
		System.out.println("serial by writeObject method");
//		try {
//			oos.defaultWriteObject();
//			oos.writeBytes(this.firstName);
//			oos.writeBytes(this.lastName);
			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	
//	该方法相当于一个公有的构造方法，在对象反序列化时被调用
	private void readObject(ObjectInputStream ois) {
		
	}
	
	
	
}
