/**   
 * @Title: Injection.java 
 * @Package com.denny.ioc.annotation 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月3日 下午10:01:33 
 * @version V1.0   
 */
package com.denny.ioc.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
/** 
 * @ClassName: Injection 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月3日 下午10:01:33 
 *  
 */
public @interface Injection {
	
}
