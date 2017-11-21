/**   
 * @Title: BeanDefinition.java 
 * @Package com.denny.ioc.bean 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月4日 上午6:20:00 
 * @version V1.0   
 */
package com.denny.ioc.bean;

import java.util.ArrayList;
import java.util.List;

/** 
 * @ClassName: BeanDefinition 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月4日 上午6:20:00 
 *  
 */
public class BeanDefinition {

	private Object bean;
	
	private Class<?> beanClass;
	
	private String beanClassName;
	
	private List<AttributeType> attributeTypeList = new ArrayList<AttributeType>();
	
	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */
	public BeanDefinition() {
		// TODO Auto-generated constructor stub
	}

	/** 
	 * @return bean 
	 */
	public Object getBean() {
		return bean;
	}

	/**
	 * @param bean the bean to set
	 */
	public void setBean(Object bean) {
		this.bean = bean;
	}

	/** 
	 * @return beanClass 
	 */
	public Class<?> getBeanClass() {
		return beanClass;
	}

	/**
	 * @param beanClass the beanClass to set
	 */
	public void setBeanClass(Class<?> beanClass) {
		this.beanClass = beanClass;
	}

	/** 
	 * @return beanClassName 
	 */
	public String getBeanClassName() {
		return beanClassName;
	}

	/**
	 * @param beanClassName the beanClassName to set
	 */
	public void setBeanClassName(String beanClassName) {
		this.beanClassName = beanClassName;
		
		try {
			this.beanClass = Class.forName(beanClassName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/** 
	 * @return attributeTypeList 
	 */
	public List<AttributeType> getAttributeTypeList() {
		return attributeTypeList;
	}

	/**
	 * @param attributeTypeList the attributeTypeList to set
	 */
	public void setAttributeTypeList(List<AttributeType> attributeTypeList) {
		this.attributeTypeList = attributeTypeList;
	}

	public void addAttributeType(AttributeType attributeType) {
		this.attributeTypeList.add(attributeType);
	}

	/* (non-Javadoc) 
	 * <p>Title: toString</p> 
	 * <p>Description: </p> 
	 * @return 
	 * @see java.lang.Object#toString() 
	 */
	@Override
	public String toString() {
		return "BeanDefinition [bean=" + bean + ", beanClass=" + beanClass + ", beanClassName=" + beanClassName
				+ ", attributeTypeList=" + attributeTypeList + "]";
	}
}
