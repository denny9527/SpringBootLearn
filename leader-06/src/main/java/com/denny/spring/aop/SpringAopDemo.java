/**   
 * @Title: SpringAopDemo.java 
 * @Package com.denny.spring.aop 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月14日 下午4:19:24 
 * @version V1.0   
 */
package com.denny.spring.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.denny.common.BaseDao;
import com.denny.common.IBaseService;
import com.denny.common.extend.ExtendService;
import com.denny.common.extend.ExtendServiceImpl;
import com.denny.common.user.User;
import com.denny.common.user.UserDao;
import com.denny.common.user.UserService;
import com.denny.spring.aop.advice.CustomBeforeAdvice;

/** 
 * @ClassName: SpringAopDemo 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月14日 下午4:19:24 
 *  
 */
@Configuration
//@EnableAspectJAutoProxy(proxyTargetClass = true)//启动自动代理
@EnableAspectJAutoProxy
public class SpringAopDemo {

	private final static Logger logger = LoggerFactory.getLogger(SpringAopDemo.class);
	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */
	public SpringAopDemo() {
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
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.denny.common", "com.denny.spring.aop");
		//JDK dynamic proxy
		IBaseService<User> baseService = (IBaseService<User>)applicationContext.getBean("userService");
		System.out.println(baseService);
		//System.out.println(AopContext.currentProxy());
		User user = new User();
		user.setUserId("1");
		user.setUserName("张奎");
		user.setPassword("123456");
		user.setEnabled("1");
		baseService.save(user);
		
		ExtendService extendService = (ExtendService)applicationContext.getBean("userService");
		extendService.exec();
		applicationContext.registerShutdownHook();
		
		//proxy factory 的使用
//		ProxyFactory factory = new ProxyFactory(new UserDao());
//		factory.addInterface(BaseDao.class);
//		factory.addAdvice(new CustomBeforeAdvice());
//		factory.setExposeProxy(true);
//		
//		BaseDao baseDao = (BaseDao) factory.getProxy();
//		
//		User user = new User();
//		user.setUserId("1");
//		user.setUserName("张奎");
//		user.setPassword("123456");
//		user.setEnabled("1");
//		baseDao.save(user);
		 
	}

}
