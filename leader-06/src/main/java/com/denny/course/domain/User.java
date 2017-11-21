/**   
 * @Title: User.java 
 * @Package com.denny.user 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月3日 下午9:40:04 
 * @version V1.0   
 */
package com.denny.course.domain;

import java.util.Date;

/** 
 * @ClassName: User 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月3日 下午9:40:04 
 *  
 */
public class User {

	private Long id;
	
	private String name;
	
	private String password;
	
	private String enabled;
	
	private Date regTime;
	
	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */
	public User() {
		// TODO Auto-generated constructor stub
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
	 * @return name 
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/** 
	 * @return password 
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/** 
	 * @return enabled 
	 */
	public String getEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	/** 
	 * @return regTime 
	 */
	public Date getRegTime() {
		return regTime;
	}

	/**
	 * @param regTime the regTime to set
	 */
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	/* (non-Javadoc) 
	 * <p>Title: toString</p> 
	 * <p>Description: </p> 
	 * @return 
	 * @see java.lang.Object#toString() 
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", enabled=" + enabled + ", regTime="
				+ regTime + "]";
	}


}
