/**   
 * @Title: UserInfo.java 
 * @Package com.denny.domain 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年10月19日 下午9:30:52 
 * @version V1.0   
 */
package com.denny.domain;

import java.io.Serializable;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/** 
 * @ClassName: UserInfo 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年10月19日 下午9:30:52 
 *  
 */
public class UserInfo implements Serializable {

	private static final long serialVersionUID = -5236052360729736575L;

	@NotNull(message = "{userinfo.name.noempty.invalid}")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "{userinfo.name.pattern.invalid}")
	@Size(min = 6, max = 18, message = "{userinfo.name.size.invalid}")
	private String name;
	
	@NotNull(message = "{userinfo.age.noempty.invalid}")
	@Min(value = 18, message = "{userinfo.age.size.invalid}")
	@Max(value = 99, message = "{userinfo.age.size.invalid}")
	private Integer age;

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */
	public UserInfo() {
		// TODO Auto-generated constructor stub
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
	 * @return age 
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

}
