package com.tian.serializable.bytes;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


/**
 * 使用write(byte[])方式产生的byte[],比使用writeObject的多了6byte前缀
 * @author tian
 *
 */
public class SerializeByteMain {
	
	public static void main(String[] args) throws Exception {
		Sample sample = new Sample();
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("serializable_sample")))) {
			oos.writeObject(sample);
		}
		
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
			oos.writeObject(sample);
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("bytes_sample")))) {
			oos.write(baos.toByteArray());
		}

	}
	
	static class Sample implements Serializable {

		private static final long serialVersionUID = -1023610247118710910L;
		
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
	}
	
}
