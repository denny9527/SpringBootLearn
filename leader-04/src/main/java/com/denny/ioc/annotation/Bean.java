/**   
 * @Title: Bean.java 
 * @Package com.denny.ioc.annotation 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月3日 下午9:58:33 
 * @version V1.0   
 */
package com.denny.ioc.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(TYPE)
/** 
 * @ClassName: Bean 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月3日 下午9:58:33 
 *  
 */
public @interface Bean {
	String value();
}
