/**   
 * @Title: CourseQuery.java 
 * @Package com.denny.course.query 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月9日 上午10:05:15 
 * @version V1.0   
 */
package com.denny.course.query;

import java.math.BigDecimal;

/** 
 * @ClassName: CourseQuery 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月9日 上午10:05:15 
 *  
 */
public class CourseQuery {
	
	private Long id;
	
	private String name;
	
	private BigDecimal mark;

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */
	public CourseQuery() {
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
	 * @return mark 
	 */
	public BigDecimal getMark() {
		return mark;
	}

	/**
	 * @param mark the mark to set
	 */
	public void setMark(BigDecimal mark) {
		this.mark = mark;
	}

}
