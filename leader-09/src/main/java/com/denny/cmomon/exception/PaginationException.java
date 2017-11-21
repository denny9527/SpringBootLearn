/**   
 * @Title: PaginationException.java 
 * @Package com.denny.cmomon.exception 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年8月24日 下午6:05:23 
 * @version V1.0   
 */
package com.denny.cmomon.exception;

/** 
 * @ClassName: PaginationException 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年8月24日 下午6:05:23 
 *  
 */
public class PaginationException extends BaseException {

	/** 
	 * @Fields serialVersionUID : TODO 
	 */ 
	private static final long serialVersionUID = -1666086267092785585L;

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */
	public PaginationException() {
		// TODO Auto-generated constructor stub
	}

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p> 
	 * @param message 
	 */
	public PaginationException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p> 
	 * @param cause 
	 */
	public PaginationException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p> 
	 * @param message
	 * @param cause 
	 */
	public PaginationException(String message, Throwable cause) {
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
	public PaginationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
