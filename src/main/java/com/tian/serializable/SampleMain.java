package com.tian.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 
 * @author tian
 */

public class SampleMain {

	public static void main(String[] args) throws Exception {
		
//		serialize();
		deserialize();
	}
	
	static void deserialize() throws Exception {
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("sample")));
		Sample sample = (Sample)objectInputStream.readObject();
		objectInputStream.close();
		System.out.println(sample);
	}
	
	static void serialize() throws Exception {
		Sample sample = new Sample();
		sample.setName("ttt");
		sample.setDesc("desc");
		
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("sample")));
		objectOutputStream.writeObject(sample);
		objectOutputStream.close();
	}
}
