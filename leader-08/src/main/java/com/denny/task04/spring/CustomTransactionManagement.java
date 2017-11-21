/**   
 * @Title: CustomTransactionManagement.java 
 * @Package com.denny.task04.spring 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年10月7日 下午5:33:09 
 * @version V1.0   
 */
package com.denny.task04.spring;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.TransactionManagementConfigurationSelector;
import org.springframework.transaction.interceptor.TransactionAttribute;

/** 
 * @ClassName: CustomTransactionManagement 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年10月7日 下午5:33:09 
 *  
 */
@Retention(RUNTIME)
@Target(TYPE)
@Documented
@EnableAspectJAutoProxy
@Import(CustomTransactionManagementConfiguration.class)
public @interface CustomTransactionManagement {
	
	String expression() default "";
	
	TransactionAttribute[] transactionAttributes();
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target({})
	public @interface TransactionAttribute {
		
		String methodName();
		
		boolean readOnly() default false;
		
		Isolation isolation() default Isolation.DEFAULT;
		
		Propagation propagation() default Propagation.REQUIRED;
		
		Class<? extends Throwable>[] rollbackFor() default {};
		
		Class<? extends Throwable>[] noRollbackFor() default {};
		
	}
}
