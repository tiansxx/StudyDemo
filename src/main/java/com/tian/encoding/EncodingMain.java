package com.tian.encoding;

import java.util.Arrays;

import javax.xml.bind.DatatypeConverter;

/**
 * String	文本
 * byte		字节
 * 
 * 1byte = 8bit, 1bit表示一个2进制位
 * 16进制,一个16进制位由4bit组成
 * 8进制,一个8进制位由3bit组成
 * @author tian
 */

public class EncodingMain {
	
	public static void main(String[] args) {
		
		byte[] ba = new byte[] {97, 98, 99};
		System.out.println(ba);						//[B@5c3f1224
		System.out.println(Arrays.toString(ba));	//[97, 98, 99]
		System.out.println(new String(ba));			//abc
		
		String s = "abc";
		System.out.println(s);								//abc
		System.out.println(Arrays.toString(s.getBytes()));	//[97, 98, 99]
		System.out.println(new String(s.getBytes()));		//abc
		
		int i = 16;
		System.out.println(Integer.toBinaryString(i));		//10000
		System.out.println(Integer.toOctalString(i));		//20
		System.out.println("0x" + Integer.toHexString(i));	//0x10
		System.out.println(Integer.toString(i, 2));
		System.out.println(Integer.toString(i, 8));
		System.out.println("0x" + Integer.toString(i, 16));
		
		byte[] bi = String.valueOf(i).getBytes();
		System.out.println(Arrays.toString(bi));
		System.out.println("0x" + DatatypeConverter.printHexBinary(bi));
		
	}
}
