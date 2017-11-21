/**   
 * @Title: ServiceAspect.java 
 * @Package com.denny.course.spring.aop 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月17日 上午9:11:22 
 * @version V1.0   
 */
package com.denny.course.spring.aop;

import java.sql.SQLException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @ClassName: ServiceAspect
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年9月17日 上午9:11:22
 * 
 */
@Component("serviceAspect")
@Aspect
public class ServiceAspect {

	private final static Logger logger = LoggerFactory.getLogger(ServiceAspect.class);
	
	@Autowired
	private TransactionManager transactionManager;
	
	@Autowired
	private ConnectionManager connectionManager;

	@Pointcut("execution(* com.denny.course..*Service.*(..))")
	public void serviceMethod() {
	}

	@Before("serviceMethod()")
	public void methodExecBefore(JoinPoint joinPoint) throws SQLException {
		Object target = joinPoint.getTarget();
		String methodName = joinPoint.getSignature().getName();
		if (isTransactionManage(methodName)) {
			logger.info("调用目标对象:"+target+" 方法:"+methodName+"事务开启");
			transactionManager.beginTransaction();	
		}else {
			logger.info("调用目标对象:"+target+" 方法:"+methodName+"事务不开启");
		}
	}
	
	@AfterReturning("serviceMethod()")
	public void methodExecAfterReturning(JoinPoint joinPoint) throws SQLException {
		String methodName = joinPoint.getSignature().getName();
		Object target = joinPoint.getTarget();
		if (isTransactionManage(methodName)) {
			transactionManager.commitTransaction();
			logger.info("调用目标对象:"+target+" 方法:"+methodName+"事务提交");
		}
		connectionManager.closeConnection();
	}
	
	@AfterThrowing(pointcut= "serviceMethod()", throwing = "ex")
	public void methodExecAfterThrowing(JoinPoint joinPoint, Exception ex) throws SQLException {
		String methodName = joinPoint.getSignature().getName();
		Object target = joinPoint.getTarget();
		boolean isTransaction = isTransactionManage(methodName);
		if(ex instanceof RuntimeException) {
			if (isTransaction) {
				transactionManager.rollbackTransaction();
				logger.info("调用目标对象:"+target+" 方法:"+methodName+"事务回滚");
			}
		}else {
			if(isTransaction) {
				transactionManager.commitTransaction();
				logger.info("调用目标对象:"+target+" 方法:"+methodName+"事务提交");
			}
		}
		connectionManager.closeConnection();
	}
	
	private boolean isTransactionManage(String methodName) {
		return methodName.startsWith("create") || methodName.startsWith("update") || methodName.startsWith("save")
				|| methodName.startsWith("delete");
	}

}
