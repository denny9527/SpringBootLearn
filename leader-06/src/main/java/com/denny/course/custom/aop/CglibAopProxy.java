/**   
 * @Title: CglibAopProxy.java 
 * @Package com.denny.course.jdk.aop 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月19日 下午1:08:12 
 * @version V1.0   
 */
package com.denny.course.custom.aop;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @ClassName: CglibAopProxy
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年9月19日 下午1:08:12
 * 
 */
public class CglibAopProxy implements AopProxy {

	private final static Logger logger = LoggerFactory.getLogger(CglibAopProxy.class);

	private Object target;

	private List<Advice> adviceList;

	public CglibAopProxy(Object target, List<Advice> adviceList) {
		this.target = target;
		this.adviceList = adviceList;
	}

	@Override
	public Object getProxy() {
		Enhancer enhancer = new Enhancer();
		enhancer.setClassLoader(target.getClass().getClassLoader());
		enhancer.setSuperclass(target.getClass());
		enhancer.setCallback(new DynamicAdvisedInterceptor());
		return enhancer.create();
	}

	@Override
	public Object getProxy(ClassLoader classLoader) {
		Enhancer enhancer = new Enhancer();
		enhancer.setClassLoader(classLoader);
		enhancer.setSuperclass(target.getClass());
		enhancer.setCallback(new DynamicAdvisedInterceptor());
		return enhancer.create();
	}

	private class DynamicAdvisedInterceptor implements MethodInterceptor {

		@Override
		public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
			Object returnVal = null;
			if (adviceList.size() > 0) {
				returnVal = new CglibMethodInvocation(proxy, target, method, args, target.getClass(), methodProxy,
						adviceList).proceed();
			} else {
				returnVal = methodProxy.invoke(target, args);
			}
			return returnVal;
		}
	}

	private class CglibMethodInvocation extends ReflectiveMethodInvocation {
		private final MethodProxy methodProxy;

		public CglibMethodInvocation(Object proxy, Object target, Method method, Object[] arguments,
				Class<?> targetClass, MethodProxy methodProxy, List<Advice> adviceList) {
			super(proxy, target, method, arguments, targetClass, adviceList);
			this.methodProxy = methodProxy;

		}
		@Override
		protected Object invokeTargetMethod() throws Throwable {
			return methodProxy.invoke(target, this.arguments);
		}
	}
}

