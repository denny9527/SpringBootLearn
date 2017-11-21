/**   
 * @Title: Org.java 
 * @Package com.denny.course.domain 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月17日 上午8:12:00 
 * @version V1.0   
 */
package com.denny.course.domain;

/** 
 * @ClassName: Org 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月17日 上午8:12:00 
 *  
 */
public class Org {
	
	private Long id;
	
	private String orgName;
	
	private String orgAddress;
	
	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */
	public Org() {
		// TODO Auto-generated constructor stub
	}

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p> 
	 * @param id
	 * @param orgName
	 * @param orgAddress 
	 */
	public Org(Long id, String orgName, String orgAddress) {
		super();
		this.id = id;
		this.orgName = orgName;
		this.orgAddress = orgAddress;
	}



	/** 
	 * @return id 
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/** 
	 * @return orgName 
	 */
	public String getOrgName() {
		return orgName;
	}

	/**
	 * @param orgName the orgName to set
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	/** 
	 * @return orgAddress 
	 */
	public String getOrgAddress() {
		return orgAddress;
	}

	/**
	 * @param orgAddress the orgAddress to set
	 */
	public void setOrgAddress(String orgAddress) {
		this.orgAddress = orgAddress;
	}

}
