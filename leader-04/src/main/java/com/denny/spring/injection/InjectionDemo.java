/**   
 * @Title: InjectionDemo.java 
 * @Package com.denny.spring.injection 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月3日 下午5:27:35 
 * @version V1.0   
 */
package com.denny.spring.injection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/** 
 * @ClassName: InjectionDemo 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月3日 下午5:27:35 
 *  
 */
public class InjectionDemo {

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */
	public InjectionDemo() {
		// TODO Auto-generated constructor stub
	}

	/** 
	 * @Title: main 
	 * @Description: TODO 
	 * @param @param args
	 * @return void
	 * @throws 
	 */
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.denny.spring.injection");
		MyInvocationBean invocationBean = (MyInvocationBean)context.getBean("myInvocationBean");
		invocationBean.printInjectionBeanList();
		invocationBean.printInjectionBeanMap();
		invocationBean.printMyHelloBean();
		invocationBean.printMyBaseBean();
		//invocationBean.handle();
		//invocationBean.exec(myBaseBean);

	}

}
