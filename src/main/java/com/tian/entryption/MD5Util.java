package com.tian.entryption;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5 摘要算法,单向加密,无法解密
 * @author tian
 *
 */
public class MD5Util {
	
	private static final char[] DIGITS =
        {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
	
	public static String md5(String input) throws NoSuchAlgorithmException {
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
		return new String(out);
	}
	
}
