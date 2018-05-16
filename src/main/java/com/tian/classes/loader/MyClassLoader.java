package com.tian.classes.loader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {

	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		
		if (name.startsWith("com.tian"))
			return this.findClass(name);
		else 
			return super.loadClass(name);
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] classData = getClassData(name);
		
		Class<?> clazz = this.defineClass(name, classData, 0, classData.length);
		
		resolveClass(clazz);
		
		return clazz;
	} 
	
	private byte[] getClassData(String className) {
		String path = "E:\\workspace_prj\\StudyDemo\\target\\classes\\com\\tian\\classes\\loader\\Sample.class";
		
		InputStream ins = null;
		try {
			ins = new FileInputStream(path);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int buffSize = 4096;
			byte[] buffer = new byte[buffSize];
			int bytesNumRead = 0;
			while ((bytesNumRead = ins.read(buffer)) != -1) {
				baos.write(buffer, 0, bytesNumRead);
			}
			return baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ins != null) {
				try {
					ins.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
