/**   
 * @Title: AnnotationBeanDefinitionReader.java 
 * @Package com.denny.ioc.bean 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月4日 上午8:36:20 
 * @version V1.0   
 */
package com.denny.ioc.bean;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.MethodParameterNamesScanner;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.scanners.TypeElementsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import com.denny.common.BaseDao;
import com.denny.common.BaseService;
import com.denny.common.user.UserDao;
import com.denny.common.user.UserService;
import com.denny.ioc.annotation.Bean;
import com.denny.ioc.annotation.Injection;

/**
 * @ClassName: AnnotationBeanDefinitionReader
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年9月4日 上午8:36:20
 * 
 */
public class AnnotationBeanDefinitionReader extends AbstractBeanDefinitionReader {

	private static Reflections reflections;

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	public AnnotationBeanDefinitionReader(String packageName) {
		super(packageName);
		reflections = new Reflections(
				new ConfigurationBuilder().setUrls(ClasspathHelper.forPackage(this.getPackageName())).setScanners(
						new ResourcesScanner(), new TypeAnnotationsScanner(), new TypeElementsScanner(),
						new MethodParameterNamesScanner(), new SubTypesScanner()));
	}

	/*
	 * (non-Javadoc) <p>Title: loadBeanDefinitions</p> <p>Description: </p>
	 * 
	 * @param location
	 * 
	 * @throws Exception
	 * 
	 * @see
	 * com.denny.ioc.bean.BeanDefinitionReader#loadBeanDefinitions(java.lang.String)
	 */
	@Override
	public void loadBeanDefinitions() throws Exception {
		// 扫描包加载Bean定义
		Set<Class<?>> beanClassesList = reflections.getTypesAnnotatedWith(Bean.class);
		for (Class<?> clz : beanClassesList) {
			Bean beanAnnoArr = clz.getAnnotation(Bean.class);
			String beanName = beanAnnoArr.value();
			BeanDefinition beanDefinition = new BeanDefinition();
			beanDefinition.setBeanClass(clz);
			beanDefinition.setBeanClassName(clz.getName());
			handleproperty(beanDefinition, beanClassesList);
			this.getRegistry().put(beanName, beanDefinition);
		}
	}

	public void handleproperty(BeanDefinition beanDefinition, Set<Class<?>> beanClassesList) {
		Class<?> beanClass = beanDefinition.getBeanClass();
		List<Field> fieldList = new ArrayList<Field>();
		Class<?> tmpClass = beanClass;
		while (tmpClass != null) {
			fieldList.addAll(Arrays.asList(tmpClass.getDeclaredFields()));
			tmpClass = tmpClass.getSuperclass();
		}
		for (Field field : fieldList) {
			Injection injection = field.getAnnotation(Injection.class);
			if (injection != null) {
				Type fieldType = field.getGenericType();
				if ((fieldType != null && (fieldType instanceof ParameterizedType))) {
					Type rawType = ((ParameterizedType) fieldType).getRawType();
					Type[] beanParamTypeArr = ((ParameterizedType) beanClass.getGenericSuperclass()).getActualTypeArguments();
					for (Class<?> clz : beanClassesList) {
						if (beanClass != clz) {
							if (((Class<?>) rawType).isAssignableFrom(clz) || (Class<?>) rawType == clz) {
								ParameterizedType genericSuperClassType = (ParameterizedType) clz.getGenericSuperclass();
								if (genericSuperClassType != null) {
									Type[] injectionParamTypeArr = genericSuperClassType.getActualTypeArguments();
									if (injectionParamTypeArr.length > 0
											&& (injectionParamTypeArr.length == beanParamTypeArr.length)) {
										boolean isInjection = true;
										int i = 0;
										for(Type type : injectionParamTypeArr) {
											if(!type.equals(beanParamTypeArr[i])) isInjection = false;
											i++;
										}
										if(isInjection) {
											AttributeType attributeType = new AttributeType(field.getName(), clz);
											beanDefinition.addAttributeType(attributeType);
										}
									}
								}
							}
						}
					}
				}
			}

		}
	}

}
