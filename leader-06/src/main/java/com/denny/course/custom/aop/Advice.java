/**   
 * @Title: IAdvice.java 
 * @Package com.denny.course.service 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月17日 下午9:15:23 
 * @version V1.0   
 */
package com.denny.course.custom.aop;

import java.lang.reflect.Method;

/** 
 * @ClassName: IAdvice 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月17日 下午9:15:23 
 *  
 */
public interface Advice {
	
	public void execute(Object target, Method method) throws Throwable;

}
