/**   
 * @Title: AbstractApplicationContext.java 
 * @Package com.denny.ioc.context 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月4日 上午6:12:01 
 * @version V1.0   
 */
package com.denny.ioc.context;

import com.denny.ioc.bean.factory.AbstractBeanFactory;

/** 
 * @ClassName: AbstractApplicationContext 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月4日 上午6:12:01 
 *  
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

	protected AbstractBeanFactory beanFactory;

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */
	public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}

	/* (non-Javadoc) 
	 * <p>Title: getBean</p> 
	 * <p>Description: </p> 
	 * @param name
	 * @return 
	 * @see com.denny.ioc.bean.factory.BeanFactory#getBean(java.lang.String) 
	 */
	@Override
	public Object getBean(String name) {
		return beanFactory.getBean(name);
	}

	/* (non-Javadoc) 
	 * <p>Title: getBean</p> 
	 * <p>Description: </p> 
	 * @param requiredType
	 * @return 
	 * @see com.denny.ioc.bean.factory.BeanFactory#getnBean(java.lang.Class) 
	 */
	@Override
	public <T> T getBean(Class<T> requiredType) {
		return beanFactory.getBean(requiredType);
	}

	@Override
	public boolean containsBean(String name) {
		return beanFactory.containsBean(name);
	}
	
	/*
	 * 启动加载指定包下所有Bean(扫描@Bean和@Injection注解)
	 */
	protected void loadBeans() {
		beanFactory.instantiateBeans();
	}
	
	/*
	 * 加载所有Bean定义
	 */
	protected abstract void loadBeanDefinitions(AbstractBeanFactory beanFactory) throws Exception;

}
