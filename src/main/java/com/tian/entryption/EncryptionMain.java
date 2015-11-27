package com.tian.entryption;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionMain {
	
	static final char[] DIGITS =
        {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

	public static void main(String[] args) throws NoSuchAlgorithmException {
		md5("test");
	}
	
	static void md5(String input) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		
//		md.update(input.getBytes());
		byte[] hash = md.digest(input.getBytes(StandardCharsets.UTF_8));
		int length = hash.length;
		char[] out = new char[length << 1];
// 		two characters form the hex value.
		for (int i = 0, j = 0; i < length; i++) {
            out[j++] = DIGITS[(0xF0 & hash[i]) >>> 4];
            out[j++] = DIGITS[0x0F & hash[i]];
		}
		System.out.println(new String(out));
	}
	
}
