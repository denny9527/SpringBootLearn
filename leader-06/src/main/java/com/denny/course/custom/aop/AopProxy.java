/**   
 * @Title: AopProxy.java 
 * @Package com.denny.course.jdk.aop 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月17日 下午9:35:42 
 * @version V1.0   
 */
package com.denny.course.custom.aop;

/** 
 * @ClassName: AopProxy 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月17日 下午9:35:42 
 *  
 */
public interface AopProxy {

	Object getProxy();
	
	Object getProxy(ClassLoader classLoader);
	
}

