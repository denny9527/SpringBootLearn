/**   
 * @Title: AbstractBeanDefinitionReader.java 
 * @Package com.denny.ioc.bean 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月4日 上午6:28:14 
 * @version V1.0   
 */
package com.denny.ioc.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** 
 * @ClassName: AbstractBeanDefinitionReader 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月4日 上午6:28:14 
 *  
 */
public abstract class AbstractBeanDefinitionReader {

	private Map<String,BeanDefinition> registry;
	
	private String packageName;

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p> 
	 * @param registry 
	 */
	public AbstractBeanDefinitionReader(String packageName) {
		super();
		this.registry = new ConcurrentHashMap<String,BeanDefinition>();
		this.packageName = packageName;
	}

	public abstract void loadBeanDefinitions() throws Exception;

	/** 
	 * @return registry 
	 */
	public Map<String, BeanDefinition> getRegistry() {
		return registry;
	}

	/**
	 * @param registry the registry to set
	 */
	public void setRegistry(Map<String, BeanDefinition> registry) {
		this.registry = registry;
	}

	/** 
	 * @return packageName 
	 */
	public String getPackageName() {
		return packageName;
	}

	/**
	 * @param packageName the packageName to set
	 */
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

}
