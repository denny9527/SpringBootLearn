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

	/* (non-Javadoc) 
	 * <p>Title: hashCode</p> 
	 * <p>Description: </p> 
	 * @return 
	 * @see java.lang.Object#hashCode() 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enabled == null) ? 0 : enabled.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((regDate == null) ? 0 : regDate.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	/* (non-Javadoc) 
	 * <p>Title: equals</p> 
	 * <p>Description: </p> 
	 * @param obj
	 * @return 
	 * @see java.lang.Object#equals(java.lang.Object) 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (enabled == null) {
			if (other.enabled != null)
				return false;
		} else if (!enabled.equals(other.enabled))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (regDate == null) {
			if (other.regDate != null)
				return false;
		} else if (!regDate.equals(other.regDate))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	/* (non-Javadoc) 
	 * <p>Title: toString</p> 
	 * <p>Description: </p> 
	 * @return 
	 * @see java.lang.Object#toString() 
	 */
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", enabled=" + enabled
				+ ", regDate=" + regDate + "]";
	}

}
