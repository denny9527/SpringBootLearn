/**   
 * @Title: MyBean.java 
 * @Package com.denny.spring.config 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月3日 下午8:17:50 
 * @version V1.0   
 */
package com.denny.spring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.denny.spring.event.EmailService;

/** 
 * @ClassName: MyBean 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月3日 下午8:17:50 
 *  
 */
@Component
public class MyBean {

	public static final Logger logger = LoggerFactory.getLogger(MyBean.class);
	
	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */
	public MyBean() {
		// TODO Auto-generated constructor stub
	}

	public void exec() {
		logger.info("MyBean执行");
	}
}
