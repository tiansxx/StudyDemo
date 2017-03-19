package com.tian.instrumentation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * 
 * 通过transform方法,完成类定义的转换
 *
 * @author tian
 *
 */

public class EnhanceHandlerAgent implements ClassFileTransformer {

	private static int count = 0;
	
	public static int getCount() {
		return count;
	}
	
	@Override
	public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
			ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
		count++;
		return getBytesFromFile(className);
	}
	
	@SuppressWarnings("resource")
	private byte[] getBytesFromFile(String className)
	{
		try {
			File file = new File(getPathFromClassName(className));
			int length = (int) file.length();
			byte[] target = new byte[length];
			
			FileInputStream fis = new FileInputStream(file);
			int offset = 0;
			int numOfRead = 0;
			while ((offset < length) && (numOfRead = fis.read(target, offset, length - offset)) >= 0) {
				offset += numOfRead;
			}
			if (offset < length) {
				throw new IOException("Could not completely read file " + file.getName());
			}
			fis.close();
			
			return target;
		} catch (Exception e) {
			
		}
		return null;
	}
	
	private String getPathFromClassName(String className) {
		String fileName = "";
		return fileName;
	}

}


