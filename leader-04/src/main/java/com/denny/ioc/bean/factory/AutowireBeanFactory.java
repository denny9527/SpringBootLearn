/**   
 * @Title: AutowireBeanFactory.java 
 * @Package com.denny.ioc.bean.factory 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月4日 上午10:28:54 
 * @version V1.0   
 */
package com.denny.ioc.bean.factory;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.denny.ioc.bean.AttributeType;
import com.denny.ioc.bean.BeanDefinition;

/**
 * @ClassName: AutowireBeanFactory
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年9月4日 上午10:28:54
 * 
 */
public class AutowireBeanFactory extends AbstractBeanFactory {

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	public AutowireBeanFactory() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc) <p>Title: assembleProperty</p> <p>Description: </p>
	 * 
	 * @param bean
	 * 
	 * @param beanDefinition
	 * 
	 * @see
	 * com.denny.ioc.bean.factory.AbstractBeanFactory#assembleProperty(java.lang.
	 * Object, com.denny.ioc.bean.BeanDefinition)
	 */
	@Override
	protected void assembleProperty(Object bean, BeanDefinition beanDefinition) {
		Class<?> beanClass = beanDefinition.getBeanClass();
		List<Field> fieldList = new ArrayList<Field>();
		Class<?> tmpClass = beanClass;
		while (tmpClass != null) {
			fieldList.addAll(Arrays.asList(tmpClass.getDeclaredFields()));
			tmpClass = tmpClass.getSuperclass();
		}
		List<AttributeType> attributeTypeList = beanDefinition.getAttributeTypeList();
		for (AttributeType attrType : attributeTypeList) {
			for(Field field : fieldList) {
				if(field.getName().equals(attrType.getName())) {
					try {
						BeanDefinition beanDefinitionTmp = this.getBeanDefinition(attrType.getType());
						if(beanDefinitionTmp != null) {
							Object object = this.getBean(attrType.getType());
							if(object != null) {
								field.setAccessible(true);
								field.set(bean, object);
							}else {
								field.setAccessible(true);
								Object injectionObj = attrType.getType().newInstance();
								field.set(bean, injectionObj);
								beanDefinitionTmp.setBean(injectionObj);
							}
						}
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}

	}

}
