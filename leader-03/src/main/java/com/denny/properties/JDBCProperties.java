/**   
 * @Title: JDBCProperties.java 
 * @Package com.denny.config 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年8月25日 下午4:57:15 
 * @version V1.0   
 */
package com.denny.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/** 
 * @ClassName: JDBCProperties 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年8月25日 下午4:57:15 
 *  
 */
@Component("jdbcProperties")
@ConfigurationProperties("jdbc")
@EnableTransactionManagement
public class JDBCProperties {
	
	private String driverClassName;
	
	private String url;
	
	private String userName;
	
	private String password;

	/** 
	 * @return driverClassName 
	 */
	public String getDriverClassName() {
		return driverClassName;
	}

	/**
	 * @param driverClassName the driverClassName to set
	 */
	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
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

	/* (non-Javadoc) 
	 * <p>Title: toString</p> 
	 * <p>Description: </p> 
	 * @return 
	 * @see java.lang.Object#toString() 
	 */
	@Override
	public String toString() {
		return "JDBCProperties [driverClassName=" + driverClassName + ", url=" + url + ", userName=" + userName
				+ ", password=" + password + "]";
	}

}
