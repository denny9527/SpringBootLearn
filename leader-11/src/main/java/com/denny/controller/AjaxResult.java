/**   
 * @Title: AjaxResult.java 
 * @Package edu.ldcollege.ctrl 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年10月15日 下午1:22:21 
 * @version V1.0   
 */
package com.denny.controller;

import java.util.Map;

/** 
 * @ClassName: AjaxResult 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年10月15日 下午1:22:21 
 *  
 */
public class AjaxResult {
	
	/**
	 * 1:成功  0:失败
	 */
	private String resultCode;
	
	private String info;
	
	private String url;
	
	private Map<String, String> resultMap;

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */
	public AjaxResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p> 
	 * @param resultCode
	 * @param info
	 * @param url 
	 */
	public AjaxResult(String resultCode, String info, String url, Map<String, String> resultMap) {
		super();
		this.resultCode = resultCode;
		this.info = info;
		this.url = url;
		this.resultMap = resultMap;
	}

	/** 
	 * @return resultCode 
	 */
	public String getResultCode() {
		return resultCode;
	}

	/**
	 * @param resultCode the resultCode to set
	 */
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	/** 
	 * @return info 
	 */
	public String getInfo() {
		return info;
	}

	/**
	 * @param info the info to set
	 */
	public void setInfo(String info) {
		this.info = info;
	}

	/** 
	 * @return url 
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/** 
	 * @return resultMap 
	 */
	public Map<String, String> getResultMap() {
		return resultMap;
	}

	/**
	 * @param resultMap the resultMap to set
	 */
	public void setResultMap(Map<String, String> resultMap) {
		this.resultMap = resultMap;
	}

}
