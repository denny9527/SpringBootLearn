/**   
 * @Title: AfterThrowingAdvice.java 
 * @Package com.denny.course.jdk.aop 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月17日 下午9:17:26 
 * @version V1.0   
 */
package com.denny.course.custom.aop;

import java.lang.reflect.Method;

/** 
 * @ClassName: AfterThrowingAdvice 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月17日 下午9:17:26 
 *  
 */
public interface AfterThrowingAdvice extends Advice {
	public void execute(Object target, Method method, Throwable throwException) throws Throwable;
}
