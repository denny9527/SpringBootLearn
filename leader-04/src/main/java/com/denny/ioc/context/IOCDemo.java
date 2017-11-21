/**   
 * @Title: IOCDemo.java 
 * @Package com.denny.ioc.context 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月4日 下午3:50:13 
 * @version V1.0   
 */
package com.denny.ioc.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.denny.common.org.OrgService;
import com.denny.common.user.UserDao;
import com.denny.common.user.UserService;
import com.denny.jdk.event.MsgService;

/** 
 * @ClassName: IOCDemo 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月4日 下午3:50:13 
 *  
 */
public class IOCDemo {
	
	private static final Logger logger = LoggerFactory.getLogger(MsgService.class);

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */
	public IOCDemo() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @throws Exception  
	 * @Title: main 
	 * @Description: TODO 
	 * @param @param args
	 * @return void
	 * @throws 
	 */
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new AnnotationConfigApplicationContext("com.denny.common");
		logger.info("从容器中获取UserService:"+context.getBean(UserService.class));
		logger.info("从容器中获取UserService依赖的UserDao:"+((UserService)context.getBean("userService")).getBaseDao());
		logger.info("从容器中获取UserDao:"+context.getBean("userDao"));
		
		logger.info("从容器中获取OrgService:"+context.getBean(OrgService.class));
		logger.info("从容器中获取OrgService依赖的OrgDao:"+((OrgService)context.getBean("orgService")).getBaseDao());
		logger.info("从容器中获取OrgDao:"+context.getBean("orgDao"));
	}

}
