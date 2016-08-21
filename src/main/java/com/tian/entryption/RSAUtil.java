package com.tian.entryption;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.codec.binary.Base64;

/**
 * RSA 非对称加密,分公私钥
 * 
 * 加密生成byte[],解密时最好直接用该byte[],不要使用new String(byte[])之后再String.getBytes()
 * 
 * 加密后产生的byte数组转成string时要在各byte之间加个标识符,我加了个空格,然后再根据空格分隔转换回byte数组。
 * 如果不加标识符,由于byte值可能是一位到三位,无法知道某一个byte是在哪里结束。
 * 当然也可以在转成string时补0。或者转成16进制固定为两位长
 * 
 * @author tian
 *
 */
public class RSAUtil {

	private static final String ALGORITHM = "RSA";
	
	private static final String SIGNATURE_ALGORITHM = "MD5withRSA";

	private static final String PRIVATE_KEY_FILE = "I:/keys/private.key";

	private static final String PUBLIC_KEY_FILE = "I:/keys/public.key";
	
	private static final int MAX_DECRYPT_BLOCK = 128;
	
	private static final int MAX_ENCRYPT_BLOCK = 117;
	
	private static void rsaKeyGen() {
		try {
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
			keyGen.initialize(1024);
			KeyPair keyPair = keyGen.generateKeyPair();

			File privateKeyFile = new File(PRIVATE_KEY_FILE);
			File publicKeyFile = new File(PUBLIC_KEY_FILE);

			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(privateKeyFile));
			oos.writeObject(keyPair.getPrivate());
			oos.close();

			oos = new ObjectOutputStream(new FileOutputStream(publicKeyFile));
			oos.writeObject(keyPair.getPublic());
			oos.close();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static boolean areKeyPresent() {
		File privateKey = new File(PRIVATE_KEY_FILE);
		File publicKey = new File(PUBLIC_KEY_FILE);

		if (privateKey.exists() && publicKey.exists()) {
			return true;
		}
		return false;
	}

	/**
	 * rsa加密,明文最大长度117字节
	 * @param source
	 * @return
	 */
	public static String encrypt(String source) {
		if (!areKeyPresent()) {
			rsaKeyGen();
		}
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(new File(PUBLIC_KEY_FILE)));
			PublicKey key = (PublicKey) ois.readObject();
			return encrypt(source, key);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	public static String encrypt(String source, PublicKey key) {
		try {
//		取得公钥
			X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(key.getEncoded());
			KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
//		生成公钥
			PublicKey publicKey = keyFactory.generatePublic(x509KeySpec);
//		对数据解密
			Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			
			byte[] data = source.getBytes();
			int len = data.length;
			ByteArrayOutputStream out = new ByteArrayOutputStream();
	        int offSet = 0;
	        byte[] cache;
	        int i = 0;
	        // 对数据分段加密
	        while (len - offSet > 0) {
	            if (len - offSet > MAX_ENCRYPT_BLOCK) {
	                cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
	            } else {
	                cache = cipher.doFinal(data, offSet, len - offSet);
	            }
	            out.write(cache, 0, cache.length);
	            i++;
	            offSet = i * MAX_ENCRYPT_BLOCK;
	        }
	        byte[] encryptedData = out.toByteArray();
	        out.close();
			return Base64.encodeBase64String(encryptedData);
		} catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException
				| IllegalBlockSizeException | BadPaddingException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * rsa解密,密文最大长度128字节
	 * @param source
	 * @return
	 */
	public static String decrypt(String source) {
		if (!areKeyPresent()) {
			rsaKeyGen();
		}
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(PRIVATE_KEY_FILE)))) {
			PrivateKey key = (PrivateKey) ois.readObject();
			return decrypt(source, key);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String decrypt(String source, PrivateKey key) {
		
		try {
			PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(key.getEncoded());
			KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
			PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec); //生成新的私钥
			
			Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			
			//解密密文长度不能超过128字节,需分段解密
			byte[] encryptedData = Base64.decodeBase64(source);
			int len = encryptedData.length;
			int offset = 0;
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			byte[] cache;
			int i = 0;
			// 对数据分段解密
	        while (len - offset > 0) {
	            if (len - offset > MAX_DECRYPT_BLOCK) {
	                cache = cipher.doFinal(encryptedData, offset, MAX_DECRYPT_BLOCK);
	            } else {
	                cache = cipher.doFinal(encryptedData, offset, len - offset);
	            }
	            out.write(cache, 0, cache.length);
	            i++;
	            offset = i * MAX_DECRYPT_BLOCK;
	        }
	        byte[] decryptedData = out.toByteArray();
	        out.close();
			return new String(decryptedData);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException | InvalidKeyException | 
				IllegalBlockSizeException | BadPaddingException | IOException e1) {
			e1.printStackTrace();
		}
		
		return null;
	}
	
	public static String sign(byte[] data) {
		PrivateKey key = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(PRIVATE_KEY_FILE)))) {
			key = (PrivateKey) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(key.getEncoded());
        Signature signature;
		try {
			KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
			PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);
			signature = Signature.getInstance(SIGNATURE_ALGORITHM);
			signature.initSign(privateK);
			signature.update(data);
			return Base64.encodeBase64String(signature.sign());
		} catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | SignatureException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean verifySign(byte[] data, String sign) {
		
		PublicKey key = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(PUBLIC_KEY_FILE)))) {
			key = (PublicKey) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(key.getEncoded());
			KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
			PublicKey publicK = keyFactory.generatePublic(keySpec);
			Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
			signature.initVerify(publicK);
			signature.update(data);
			return signature.verify(Base64.decodeBase64(sign));
		} catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | SignatureException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
