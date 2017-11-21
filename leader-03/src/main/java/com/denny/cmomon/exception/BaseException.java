/**   
 * @Title: BaseException.java 
 * @Package com.denny.cmomon.exception 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年8月24日 下午6:02:31 
 * @version V1.0   
 */
package com.denny.cmomon.exception;

/** 
 * @ClassName: BaseException 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年8月24日 下午6:02:31 
 *  
 */
public class BaseException extends RuntimeException {

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */
	public BaseException() {
		// TODO Auto-generated constructor stub
	}

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p> 
	 * @param message 
	 */
	public BaseException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p> 
	 * @param cause 
	 */
	public BaseException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p> 
	 * @param message
	 * @param cause 
	 */
	public BaseException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p> 
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace 
	 */
	public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
