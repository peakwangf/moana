package com.peakwang.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.thoughtworks.xstream.core.util.Base64Encoder;

public class MD5 {

	/**
	 * 利用MD5进行加密 　　
	 * 
	 * @param str
	 *            待加密的字符串 　　
	 * @return 加密后的字符串 　　
	 */
	
	public static String EncoderByMd5(String str) {
		// 确定计算方法
		MessageDigest md5;
		String newstr = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
			Base64Encoder base64en = new Base64Encoder();
			// 加密后的字符串
			newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			
		}
		return newstr;
	}

}
