package com.tian.entryption;

import java.security.NoSuchAlgorithmException;

/**
 * 签名/验签
 * 1. 签名
 * 		使用md5算法将原始字符串加密
 * 		使用rsa算法将md5加密后的字符串再进行加密
 * 		返回rsa加密后的字符串
 * 2. 验签
 * 		使用rsa算法解密加密后的密文,得到解密字符串1
 * 		使用md5算法加密需要验签的字符串,得到密文2
 * 		比较1和2,相等表示验签成功,否则验签失败
 * 		
 * @author tian
 *
 */
public class SignUtil {

	
	private static String md5(String source) {
		try {
			String md5Result = MD5Util.md5(source);
			return md5Result;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String sign(String source) {
		String md5Result = md5(source);
		String encrypt = RSAUtil.encrypt(md5Result);
		return encrypt;
	}
	
	public static boolean verifySign(String source, String encryptedText) {
		String decryptText = RSAUtil.decrypt(encryptedText);
		return md5(source).equals(decryptText);
	}
	
}
