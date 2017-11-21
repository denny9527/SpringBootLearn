/**   
 * @Title: ConfigDemo.java 
 * @Package com.denny.spring.config 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月3日 下午8:21:16 
 * @version V1.0   
 */
package com.denny.spring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

/** 
 * @ClassName: ConfigDemo 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月3日 下午8:21:16 
 *  
 */
@Configuration
@EnableLoadTimeWeaving
@EnableSpringConfigured
public class ConfigDemo {
	
	public static final Logger logger = LoggerFactory.getLogger(ConfigDemo.class);
	
	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */
	public ConfigDemo() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.denny.spring.config");
		MyConfigBean configBean = new MyConfigBean();
		logger.info("装配的MyBean:"+configBean.getMyBean());

	}

}
