/**   
 * @Title: BizException.java 
 * @Package com.denny.common.exception 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月25日 下午4:18:14 
 * @version V1.0   
 */
package com.denny.common.exception;

/** 
 * @ClassName: BizException 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月25日 下午4:18:14 
 *  
 */
public class BizException extends RuntimeException {

	/** 
	 * @Fields serialVersionUID : TODO 
	 */ 
	private static final long serialVersionUID = -3620031441265681023L;

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */
	public BizException() {
		// TODO Auto-generated constructor stub
	}

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p> 
	 * @param message 
	 */
	public BizException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p> 
	 * @param cause 
	 */
	public BizException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p> 
	 * @param message
	 * @param cause 
	 */
	public BizException(String message, Throwable cause) {
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
	public BizException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
