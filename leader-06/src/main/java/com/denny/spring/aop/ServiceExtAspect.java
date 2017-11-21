/**   
 * @Title: ServiceExtAspect.java 
 * @Package com.denny.spring.aop 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月15日 下午3:30:12 
 * @version V1.0   
 */
package com.denny.spring.aop;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.denny.common.user.User;

/** 
 * @ClassName: ServiceExtAspect 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月15日 下午3:30:12 
 *  
 */
@Component("serviceExtAspect")
@Aspect
@Order(1)
public class ServiceExtAspect {
	
	private final static Logger logger = LoggerFactory.getLogger(ServiceAspect.class);

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */
	public ServiceExtAspect() {
		// TODO Auto-generated constructor stub
	}
	

	@Pointcut("within(com.denny.common..*Service)") // 切入点表达式
	public void userServiceMethod_1() {
	} // 切入点签名(返回值必须为void)
	
//	@Around("userServiceMethod() && args(t)")
//	public int serviceExecAround_1(User t) {
//		logger.info("(ServiceExtAspect)保存的用户信息:" + t.toString());
//		return 0;
//	}
	
	@Before("userServiceMethod_1()")
	public void serviceExecBefore_1() {
		logger.info("(ServiceExtAspect)数据操作执行前被调用了！");
	}

}
