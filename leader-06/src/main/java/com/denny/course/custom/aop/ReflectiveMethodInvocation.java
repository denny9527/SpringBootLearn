/**   
 * @Title: ReflectiveMethodInvocation.java 
 * @Package com.denny.course.jdk.aop 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月18日 上午10:30:06 
 * @version V1.0   
 */
package com.denny.course.custom.aop;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.aop.AopInvocationException;

/**
 * @ClassName: ReflectiveMethodInvocation
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年9月18日 上午10:30:06
 * 
 */
public class ReflectiveMethodInvocation {

	protected final Object proxy;

	protected final Object target;

	protected final Method method;

	protected Object[] arguments;

	private final Class<?> targetClass;

	private final List<Advice> adviceList;

	public ReflectiveMethodInvocation(Object proxy, Object target, Method method, Object[] arguments,
			Class<?> targetClass, List<Advice> adviceList) {
		this.proxy = proxy;
		this.target = target;
		this.method = method;
		this.arguments = arguments;
		this.targetClass = targetClass;
		this.adviceList = adviceList;
	}

	public Object proceed() throws Throwable {
		Object returnVal = null;
		List<BeforeAdvice> befrorAdviceList = new ArrayList<BeforeAdvice>();
		List<AfterReturningAdvice> afterReturningAdviceList = new ArrayList<AfterReturningAdvice>();
		List<AfterThrowingAdvice> afterThrowingAdviceList = new ArrayList<AfterThrowingAdvice>();
		for (Advice advice : adviceList) {
			if (advice instanceof BeforeAdvice) {
				befrorAdviceList.add((BeforeAdvice) advice);
				// advice.execute(target, method);
			} else if (advice instanceof AfterReturningAdvice) {
				afterReturningAdviceList.add((AfterReturningAdvice) advice);
			} else if (advice instanceof AfterThrowingAdvice) {
				afterThrowingAdviceList.add((AfterThrowingAdvice) advice);
			}
		}
		// before advice
		for (BeforeAdvice beforeAdvice : befrorAdviceList) {
			beforeAdvice.execute(target, method);
		}
		try {
			returnVal = invokeTargetMethod();
			// after returning advice
			for (AfterReturningAdvice afterReturningAdvice : afterReturningAdviceList) {
				afterReturningAdvice.execute(target, method);
			}
		} catch (Exception ex) {
			// after throwing advice
			for (AfterThrowingAdvice afterThrowingAdvice : afterThrowingAdviceList) {
				afterThrowingAdvice.execute(target, method, ex);
			}
			throw new AopInvocationException("动态代理执行目标方法失败:", ex);
		}
		return returnVal;
	}

	protected Object invokeTargetMethod() throws Throwable {
		return method.invoke(target, arguments);
	}

}