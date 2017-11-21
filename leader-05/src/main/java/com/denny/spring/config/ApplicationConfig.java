/**   
 * @Title: ApplicationConfig.java 
 * @Package com.denny.spring.config 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月9日 下午3:43:00 
 * @version V1.0   
 */
package com.denny.spring.config;

import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

/** 
 * @ClassName: ApplicationConfig 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月9日 下午3:43:00 
 *  
 */
@Configuration
@ComponentScan("com.denny")
public class ApplicationConfig {

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */
	public ApplicationConfig() {
		// TODO Auto-generated constructor stub
	}

}
