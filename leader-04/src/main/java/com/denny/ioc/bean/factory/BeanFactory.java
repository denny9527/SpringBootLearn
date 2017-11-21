/**   
 * @Title: BeanFactory.java 
 * @Package com.denny.ioc.factory 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月3日 下午9:45:23 
 * @version V1.0   
 */
package com.denny.ioc.bean.factory;

/** 
 * @ClassName: BeanFactory 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月3日 下午9:45:23 
 *  
 */
public interface BeanFactory {

	/*
	 * 根据名称获取Bean
	 */
	public abstract Object getBean(String name);
	
	/*
	 * 根据类型获取Bean
	 */
	public abstract <T> T getBean(Class<T> requiredType);
	
	/*
	 * 根据名称校验容器中是否包含Bean
	 */
	public abstract boolean containsBean(String name);
	
}
