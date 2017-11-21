/**   
 * @Title: AttributeType.java 
 * @Package com.denny.ioc.bean 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月4日 上午6:21:59 
 * @version V1.0   
 */
package com.denny.ioc.bean;

/** 
 * @ClassName: AttributeType 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月4日 上午6:21:59 
 *  
 */
public class AttributeType {

	private String name;
	
	private Class<?> type;

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p> 
	 * @param name
	 * @param obj 
	 */
	public AttributeType(String name, Class<?> type) {
		super();
		this.name = name;
		this.type = type;
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
	 * @return type 
	 */
	public Class<?> getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Class<?> type) {
		this.type = type;
	}

	/* (non-Javadoc) 
	 * <p>Title: toString</p> 
	 * <p>Description: </p> 
	 * @return 
	 * @see java.lang.Object#toString() 
	 */
	@Override
	public String toString() {
		return "AttributeType [name=" + name + ", type=" + type + "]";
	}

}
