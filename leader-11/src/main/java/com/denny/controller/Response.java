/**   
 * @Title: Response.java 
 * @Package com.denny.controller 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年11月5日 下午2:56:11 
 * @version V1.0   
 */
package com.denny.controller;

/** 
 * @ClassName: Response 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年11月5日 下午2:56:11 
 *  
 */
public class Response {
	
	String content;

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */
	public Response() {
		// TODO Auto-generated constructor stub
	}

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p> 
	 * @param content 
	 */
	public Response(String content) {
		super();
		this.content = content;
	}

	/** 
	 * @return content 
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

}
