/**   
 * @Title: BusinessException.java 
 * @Package com.denny.cmomon.exception 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年8月24日 下午1:41:20 
 * @version V1.0   
 */
package com.denny.cmomon.exception;

/** 
 * @ClassName: BusinessException 
 * @Description: TODO
 * @author A18ccms a18ccms_gmail_com 
 * @date 2017年8月24日 下午1:41:20 
 *  
 */
public class BusinessException extends BaseException {

	/** 
	 * @Fields serialVersionUID : TODO 
	 */ 
	private static final long serialVersionUID = 7546494439903639441L;

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */
	public BusinessException() {
		// TODO Auto-generated constructor stub
	}

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p> 
	 * @param message 
	 */
	public BusinessException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p> 
	 * @param cause 
	 */
	public BusinessException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p> 
	 * @param message
	 * @param cause 
	 */
	public BusinessException(String message, Throwable cause) {
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
	public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
