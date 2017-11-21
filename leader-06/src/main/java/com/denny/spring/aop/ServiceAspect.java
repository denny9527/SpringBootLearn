/**   
 * @Title: ServiceAspect.java 
 * @Package com.denny.spring.aop 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月14日 上午10:31:23 
 * @version V1.0   
 */
package com.denny.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.denny.common.extend.ExtendService;
import com.denny.common.extend.ExtendServiceImpl;
import com.denny.common.user.User;

/**
 * @ClassName: ServiceAspect
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年9月14日 上午10:31:23
 * 
 */
@Component("serviceAspect")
@Aspect
@Order(10)
public class ServiceAspect {

	private final static Logger logger = LoggerFactory.getLogger(ServiceAspect.class);

	@DeclareParents(value="com.denny.common.IBaseService+", defaultImpl=ExtendServiceImpl.class)
	private ExtendService extendService;
	
	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	public ServiceAspect() {
		// TODO Auto-generated constructor stub
	}

    @Pointcut("within(com.denny.common..*Service)") // 切入点表达式
	//@Pointcut("within(com.denny.common.BaseService)") // 切入点表达式
	public void userServiceMethod() {
	} // 切入点签名(返回值必须为void)

	// @Before("execution(* com.denny.common.BaseService.*(..))")
	@Before("userServiceMethod()")
	public void serviceExecBefore(JoinPoint joinPoint) {
		logger.info("JoinPoint target:"+joinPoint.getTarget());
		logger.info("JoinPoint this:"+joinPoint.getThis());
		logger.info("JoinPoint method name:"+joinPoint.getSignature().getName());
		logger.info("数据操作执行前被调用了！");
	}

	// @After("userServiceMethod()")
	// @Order(1)
	// public void serviceExecAfter() {
	// logger.info("数据操作执行后被调用了！(After)");
	// }

	// @Around("userServiceMethod()")
	// // @Order(2)
	// public int serviceExecAround(ProceedingJoinPoint joinPoint) {
	// logger.info("joinPoint args:" + joinPoint.getArgs());
	// logger.info("joinPoint target:" + joinPoint.getTarget());
	// logger.info("joinPoint proxy:" + joinPoint.getThis());
	// logger.info("数据操作执行前后被调用了！");
	// logger.info("保存的用户信息:" + t.toString());
	// Object object = null;
	// try {
	// object = joinPoint.proceed();
	// logger.info("返回结果:" + object.toString());
	// } catch (Throwable e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return 0;
	// }

	// @Around("userServiceMethod() && args(t)")
	// public int serviceExecAround(User t) {
	// logger.info("保存的用户信息:" + t.toString());
	// return 0;
	// }

	// @AfterReturning("userServiceMethod()")
	// public void serviceExecAfterReturning() {
	// logger.info("数据操作执行后被调用了！(AfterReturning)");
	// }

	// @AfterThrowing("userServiceMethod()")
	// public void serviceExecAfterThrowing() {
	// logger.info("数据操作执行异常被调用了！(AfterThrowing)");
	// }

}
