/**   
 * @Title: CustomBeforeAdvice.java 
 * @Package com.denny.spring.aop.advice 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月16日 上午8:23:44 
 * @version V1.0   
 */
package com.denny.spring.aop.advice;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;

import com.denny.spring.aop.SpringAopDemo;

/** 
 * @ClassName: CustomBeforeAdvice 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月16日 上午8:23:44 
 *  
 */
public class CustomBeforeAdvice implements MethodBeforeAdvice {

	private final static Logger logger = LoggerFactory.getLogger(CustomBeforeAdvice.class);
	
	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */
	public CustomBeforeAdvice() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc) 
	 * <p>Title: before</p> 
	 * <p>Description: </p> 
	 * @param method
	 * @param args
	 * @param target
	 * @throws Throwable 
	 * @see org.springframework.aop.MethodBeforeAdvice#before(java.lang.reflect.Method, java.lang.Object[], java.lang.Object) 
	 */
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		logger.info("自定义Advice执行了！");
	}

}
