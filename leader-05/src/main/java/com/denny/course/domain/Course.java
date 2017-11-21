/**   
 * @Title: Course.java 
 * @Package com.denny.course.domain 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月9日 上午10:03:19 
 * @version V1.0   
 */
package com.denny.course.domain;

import java.math.BigDecimal;

/** 
 * @ClassName: Course 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月9日 上午10:03:19 
 *  
 */
public class Course {

	private Long id;
	
	private String name;
	
	private BigDecimal mark;

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */
	public Course() {
		// TODO Auto-generated constructor stub
	}

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p> 
	 * @param id
	 * @param name
	 * @param mark 
	 */
	public Course(Long id, String name, BigDecimal mark) {
		super();
		this.id = id;
		this.name = name;
		this.mark = mark;
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

	/* (non-Javadoc) 
	 * <p>Title: toString</p> 
	 * <p>Description: </p> 
	 * @return 
	 * @see java.lang.Object#toString() 
	 */
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", mark=" + mark + "]";
	}

}
