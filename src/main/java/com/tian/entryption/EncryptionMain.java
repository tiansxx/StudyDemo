package com.tian.entryption;

import java.security.NoSuchAlgorithmException;

public class EncryptionMain {
	

	public static void main(String[] args) throws NoSuchAlgorithmException {
//		MD5Util.md5("test");
		
		String encryptText = RSAUtil.encrypt("tian");
		System.out.println(encryptText);
		String decryptText = RSAUtil.decrypt(encryptText);
		System.out.println(decryptText);
		
		String sign = RSAUtil.sign("tian".getBytes());
		boolean verifySign = RSAUtil.verifySign("tian".getBytes(), sign);
		System.out.println(verifySign);
		
		sign();
	}
	
	public static void sign() {
		String source = "tian";
		String signResult = SignUtil.sign(source);
		System.out.println(signResult.length() + "\t" + signResult);
		boolean verifySign = SignUtil.verifySign(source, signResult);
		System.out.println(verifySign);
	}
}
