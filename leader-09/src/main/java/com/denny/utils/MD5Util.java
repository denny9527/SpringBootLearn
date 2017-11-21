/**   
 * @Title: MD5Util.java 
 * @Package: com.denny.storage.utils 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com  
 * @date 2017年8月17日 上午10:48:58
 * @version V1.0.0
 */
package com.denny.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/** 
 * @ClassName: MD5Util 
 * @Description: TODO 
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年8月17日 上午10:48:58
 */

public final class MD5Util {

	/** 
	 * @Title: MD5Util
	 * @Description: TODO
	 */
	public MD5Util() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 加密字符串
	 * @Title: encrypt 
	 * @Description: TODO
	 * @param str
	 * @return
	 * @throws
	 */
	public static String encrypt(String str){
		String encryptStr = "";
			try {
				MessageDigest md5 = MessageDigest.getInstance("MD5");
				encryptStr = Base64.getEncoder().encodeToString(md5.digest(str.getBytes("utf-8")));
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return encryptStr;
	}

}
