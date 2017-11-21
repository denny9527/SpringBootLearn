/**   
 * @Title: AnnotationConfigApplicationContext.java 
 * @Package com.denny.ioc.context 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月4日 上午6:14:52 
 * @version V1.0   
 */
package com.denny.ioc.context;

import com.denny.ioc.bean.AnnotationBeanDefinitionReader;
import com.denny.ioc.bean.BeanDefinition;
import com.denny.ioc.bean.factory.AbstractBeanFactory;
import com.denny.ioc.bean.factory.AutowireBeanFactory;

/** 
 * @ClassName: AnnotationConfigApplicationContext 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月4日 上午6:14:52 
 *  
 */
public class AnnotationConfigApplicationContext extends AbstractApplicationContext {
	
	private String packageName;
	
	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 * @throws Exception 
	 */
	public AnnotationConfigApplicationContext(String packageName) {
		super(new AutowireBeanFactory());
		try {
			this.packageName = packageName;
			loadBeanDefinitions(this.beanFactory);
			this.loadBeans();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc) 
	 * <p>Title: loadBeanDefinitions</p> 
	 * <p>Description: </p> 
	 * @param beanFactory
	 * @throws Exception 
	 * @see com.denny.ioc.context.AbstractApplicationContext#loadBeanDefinitions(com.denny.ioc.bean.factory.AbstractBeanFactory) 
	 */
	@Override
	protected void loadBeanDefinitions(AbstractBeanFactory beanFactory) throws Exception {
		AnnotationBeanDefinitionReader beanDefinitionReader = new AnnotationBeanDefinitionReader(packageName);
		beanDefinitionReader.loadBeanDefinitions();
		for(String beanName : beanDefinitionReader.getRegistry().keySet()) {
			beanFactory.registerBeanDefinition(beanName, beanDefinitionReader.getRegistry().get(beanName));
		}
	}

}
