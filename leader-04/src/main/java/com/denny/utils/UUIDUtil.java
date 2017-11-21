/**   
 * @Title: UUIDUtil.java 
 * @Package: com.denny.utils 
 * @Description: TODO
 * @author denny 
 * @date 2017年8月19日 下午6:42:12
 * @version V1.0.0
 */
package com.denny.utils;

import java.util.UUID;

/** 
 * @ClassName: UUIDUtil 
 * @Description: TODO 
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年8月19日 下午6:42:12
 */

public final class UUIDUtil {

	/** 
	 * @Title: UUIDUtil
	 * @Description: TODO
	 */
	public UUIDUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public static String generateUUID(){
		String uuid = UUID.randomUUID().toString();
		return uuid.replaceAll("-", "");
	}

}
