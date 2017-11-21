/**   
 * @Title: User.java 
 * @Package com.denny.user 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月3日 下午9:40:04 
 * @version V1.0   
 */
package com.denny.common.user;

import java.sql.Date;

/** 
 * @ClassName: User 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月3日 下午9:40:04 
 *  
 */
public class User {

	private String userId;
	
	private String userName;
	
	private String password;
	
	private String enabled;
	
	private Date regDate;
	
	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */
	public User() {
		// TODO Auto-generated constructor stub
	}

	/** 
	 * @return userId 
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/** 
	 * @return userName 
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
	 * @return regDate 
	 */
	public Date getRegDate() {
		return regDate;
	}

	/**
	 * @param regDate the regDate to set
	 */
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
}
