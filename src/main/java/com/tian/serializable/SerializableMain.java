package com.tian.serializable;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;

public class SerializableMain {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		Name name = new Name();
		name.setFirstName("tian");
		name.setLastName("sxx");

		SerializableMain serializableMain = new SerializableMain();

		serializableMain.serialObject(name);
		serializableMain.outputObject(name);
		serializableMain.seriableObjectToFile(name);
	}
	
//	jdk的默认序列化后的对象占更多字节
	void serialObject(Name name) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(name);
		oos.flush();
		oos.close();
		byte[] bytes = baos.toByteArray();
		baos.close();
		System.out.println(bytes.length);
	}
	
	void seriableObjectToFile(Name name) throws IOException, ClassNotFoundException {
		//序列化对象
		{
			FileOutputStream fos = new FileOutputStream("seriableFile");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(name);
			oos.close();
			fos.close();
		}
		//反序列化对象
		{
			FileInputStream fis = new FileInputStream("seriableFile");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Name deseriable = (Name) ois.readObject();
			System.out.println(name + "\t" + deseriable);
			ois.close();
			fis.close();
		}
	}

	void outputObject(Name name) {
		ByteBuffer buffer = ByteBuffer.allocate(1024);

		byte[] fnbs = name.getFirstName().getBytes();
		buffer.putInt(fnbs.length);
		buffer.put(fnbs);
		byte[] lnbs = name.getLastName().getBytes();
		buffer.putInt(lnbs.length);
		buffer.put(lnbs);
		buffer.flip();

		byte[] result = new byte[buffer.remaining()];
		buffer.get(result);
		System.out.println(result.length);

	}
}
