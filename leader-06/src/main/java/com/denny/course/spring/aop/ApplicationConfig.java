/**   
 * @Title: ApplicationConfig.java 
 * @Package com.denny.course.spring.aop 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月17日 上午10:45:14 
 * @version V1.0   
 */
package com.denny.course.spring.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.denny.course.custom.aop.CustomAopApplicationConfig;
import com.denny.course.custom.aop.TransactionManageConfig;

/** 
 * @ClassName: ApplicationConfig 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月17日 上午10:45:14 
 *  
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
@ComponentScan(basePackages = {"com.denny.course"}, excludeFilters = {
		@Filter(type = FilterType.ASSIGNABLE_TYPE, value = CustomAopApplicationConfig.class), 
		@Filter(type = FilterType.ASSIGNABLE_TYPE, value = TransactionManageConfig.class)})
@EnableAspectJAutoProxy
public class ApplicationConfig {
	
	@Autowired
	private Environment environment;

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */
	public ApplicationConfig() {
		// TODO Auto-generated constructor stub
	}
	
	@Bean("dataSoruce")
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(environment.getProperty("jdbc.url"));
		dataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
		dataSource.setUsername(environment.getProperty("jdbc.userName"));
		dataSource.setPassword(environment.getProperty("jdbc.password"));
		return dataSource;
	}
}

