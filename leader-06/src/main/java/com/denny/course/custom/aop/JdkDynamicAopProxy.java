/**   
 * @Title: JdkDynamicAopProxy.java 
 * @Package com.denny.course.jdk.aop 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月17日 下午9:35:27 
 * @version V1.0   
 */
package com.denny.course.custom.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ClassUtils;

import com.denny.course.service.UserService;

/**
 * @ClassName: JdkDynamicAopProxy
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年9月17日 下午9:35:27
 * 
 */
public class JdkDynamicAopProxy implements InvocationHandler, AopProxy {

	private final static Logger logger = LoggerFactory.getLogger(JdkDynamicAopProxy.class);

	private Object target;

	private Class<?>[] interfaces;

	private List<Advice> adviceList;

	public JdkDynamicAopProxy(Object target, List<Advice> adviceList) {
		this.target = target;
		this.adviceList = adviceList;
	}

	@Override
	public Object getProxy() {
		interfaces = ClassUtils.getAllInterfaces(target);
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), interfaces, this);
	}

	@Override
	public Object getProxy(ClassLoader classLoader) {
		interfaces = ClassUtils.getAllInterfaces(target);
		return Proxy.newProxyInstance(classLoader, interfaces, this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object returnVal = null;
		if (adviceList.size() > 0) {
			returnVal = new ReflectiveMethodInvocation(getProxy(), this.target, method, args, this.target.getClass(),
					adviceList).proceed();
		} else {
			returnVal = method.invoke(this.target, args);

		}
		logger.info("动态代理执行目标对象方法返还值为:" + returnVal);
		return returnVal;
	}

}

