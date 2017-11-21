/**   
 * @Title: AbstractBeanFactory.java 
 * @Package com.denny.ioc.factory 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月3日 下午9:49:19 
 * @version V1.0   
 */
package com.denny.ioc.bean.factory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.denny.ioc.bean.BeanDefinition;

/** 
 * @ClassName: AbstractBeanFactory 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月3日 下午9:49:19 
 *  
 */
public abstract class AbstractBeanFactory implements BeanFactory {

	/*
	 * 存储Bean定义关系
	 */
	private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();
	
	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */
	public AbstractBeanFactory() {
		// TODO Auto-generated constructor stub
	}

	 @Override
	 public Object getBean(String name) {
		 BeanDefinition beanDefinition =  beanDefinitionMap.get(name);
		 Object obj = beanDefinition.getBean();
		 return obj;
	 }

	@Override
	public <T> T getBean(Class<T> requiredType) {
		Object obj = null;
		Collection<BeanDefinition> beanDefinitionColl = beanDefinitionMap.values();
		for(BeanDefinition beanDefinition : beanDefinitionColl) {
			if(requiredType == beanDefinition.getBeanClass()) {
				obj = beanDefinition.getBean();
				break;
			}
		}
		return (T)obj;
	}

	@Override
	public boolean containsBean(String name) {
		return beanDefinitionMap.containsKey(name);
	}

	/*
	 * 创建创建所有Bean对象
	 */
	public final void instantiateBeans() {
		for(BeanDefinition beanDefinition: beanDefinitionMap.values()) {
			createBean(beanDefinition);
		}
	}
	
	/*
	 * 创建Bean并装配依赖属性(对象)
	 */
	protected void createBean(BeanDefinition beanDefinition) {
		Object bean;
		try {
			bean = beanDefinition.getBean();
			if(beanDefinition.getBean() == null) {
				bean = beanDefinition.getBeanClass().newInstance();
			}
			this.assembleProperty(bean, beanDefinition);
			beanDefinition.setBean(bean);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * 注册Bean定义
	 */
	public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
		beanDefinitionMap.put(name, beanDefinition);
	}
	
	/*
	 * 装配依赖属性(对象),由AutowireBeanFactory完成
	 */
	protected abstract void assembleProperty(Object bean, BeanDefinition beanDefinition);

	/*
	 * 根据类型获取Bean定义
	 */
	protected BeanDefinition getBeanDefinition(Class<?> type) {
		BeanDefinition beanDefinition = null;
		for(BeanDefinition beanDefinitionTmp : beanDefinitionMap.values()) {
			if(beanDefinitionTmp.getBeanClass() == type) {
				beanDefinition = beanDefinitionTmp;
				break;
			}
		}
		return beanDefinition;
	}

	/** 
	 * @return beanDefinitionMap 
	 */
	protected Map<String, BeanDefinition> getBeanDefinitionMap() {
		return beanDefinitionMap;
	}

	/**
	 * @param beanDefinitionMap the beanDefinitionMap to set
	 */
	protected void setBeanDefinitionMap(Map<String, BeanDefinition> beanDefinitionMap) {
		this.beanDefinitionMap = beanDefinitionMap;
	}

}
