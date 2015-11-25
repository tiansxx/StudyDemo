package com.tian.serializable;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;

public class SerializableMain {

	public static void main(String[] args) throws IOException {

		Name name = new Name();
		name.setFirstName("tian");
		name.setLastName("sxx");

		SerializableMain serializableMain = new SerializableMain();

		serializableMain.serialObject(name);
		serializableMain.outputObject(name);
	}

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
