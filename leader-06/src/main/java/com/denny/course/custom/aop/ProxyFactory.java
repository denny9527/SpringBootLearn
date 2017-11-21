/**   
 * @Title: ProxyFactory.java 
 * @Package com.denny.course.jdk.aop 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月17日 下午9:31:42 
 * @version V1.0   
 */
package com.denny.course.custom.aop;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

/**
 * @ClassName: ProxyFactory
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年9月17日 下午9:31:42
 * 
 */
public class ProxyFactory {

	private Object target;

	private List<Advice> adviceList = new LinkedList<Advice>();
	
	private Class<?>[] interfaces;

	public ProxyFactory(Object target) {
		this.setTarget(target);
		this.setInterfaces(ClassUtils.getAllInterfaces(target));
	}

	public Object getProxy() {
		return getAopProxy(null).getProxy();
	}

	public Object getProxy(AopProxyType aopProxyType) {
		return getAopProxy(aopProxyType).getProxy();
	}

	public Object getProxy(ClassLoader classLoader) {
		return getAopProxy(null).getProxy(classLoader);
	}
	
	public Object getProxy(ClassLoader classLoader, AopProxyType aopProxyType) {
		return getAopProxy(aopProxyType).getProxy(classLoader);
	}

	public AopProxy getAopProxy(AopProxyType aopProxyType) {
		AopProxy aopProxy = null;
		if (aopProxyType == null) {
			if (interfaces.length > 0) {
				return new JdkDynamicAopProxy(target, adviceList);
			} else {
				return new CglibAopProxy(target, adviceList);
			}
		} else {
			if (aopProxyType == AopProxyType.JDK_DYNAMIC_PROXY)
				if(interfaces.length > 0) {
					aopProxy = new JdkDynamicAopProxy(target, adviceList);
				}else {
					throw new RuntimeException("目标对象:"+target+"没有任何实现的接口不可使用JDK动态代理");
				}
			if (aopProxyType == AopProxyType.CGLIB_PROXY)
				aopProxy = new CglibAopProxy(target, adviceList);
		}
		return aopProxy;
	} 
	
	public void addAdvice(Advice advice) {
		adviceList.add(advice);
	}

	/**
	 * @return target
	 */
	public Object getTarget() {
		return target;
	}

	/**
	 * @param target
	 *            the target to set
	 */
	public void setTarget(Object target) {
		this.target = target;
	}

	/**
	 * @return adviceList
	 */
	public List<Advice> getAdviceList() {
		return adviceList;
	}

	/**
	 * @param adviceList
	 *            the adviceList to set
	 */
	public void setAdviceList(List<Advice> adviceList) {
		this.adviceList = adviceList;
	}

	/** 
	 * @return interfaces 
	 */
	public Class<?>[] getInterfaces() {
		return interfaces;
	}

	/**
	 * @param interfaces the interfaces to set
	 */
	public void setInterfaces(Class<?>[] interfaces) {
		this.interfaces = interfaces;
	}

}
