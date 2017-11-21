/**   
 * @Title: CustomAopApplicationConfig.java 
 * @Package com.denny.course.jdk.aop 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月18日 下午1:01:10 
 * @version V1.0   
 */
package com.denny.course.custom.aop;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;

import com.denny.course.common.IBaseService;
import com.denny.course.domain.Org;
import com.denny.course.domain.User;
import com.denny.course.service.OrgService;
import com.denny.course.service.UserService;
import com.denny.course.spring.aop.ApplicationConfig;
import com.denny.course.spring.aop.ServiceAspect;

/**
 * @ClassName: CustomAopApplicationConfig
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年9月18日 下午1:01:10
 * 
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
@ComponentScan(basePackages = { "com.denny.course" }, excludeFilters = {
		@Filter(type = FilterType.ASSIGNABLE_TYPE, value = ApplicationConfig.class), 
		@Filter(type = FilterType.ASSIGNABLE_TYPE, value = ServiceAspect.class)})
public class CustomAopApplicationConfig {
	
	@Autowired
	private Environment environment;

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
