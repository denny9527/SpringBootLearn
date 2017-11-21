/**   
 * @Title: ApplicationConfig.java 
 * @Package com.denny.course.spring.aop 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月17日 上午10:45:14 
 * @version V1.0   
 */
package com.denny.spring.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.scheduling.config.TaskExecutorFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @ClassName: ApplicationConfig
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年9月17日 上午10:45:14
 * 
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
// @ComponentScan(basePackages = {"com.denny"})
//@EnableAspectJAutoProxy
@EnableTransactionManagement
public class ApplicationConfig {

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
	
	@Bean(name = "transactionTemplate")
	public TransactionTemplate getTransactionTemplate() {
		TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
		transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
		transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		return transactionTemplate;
	}
	
	@Bean(name = "transactionManager")
	public PlatformTransactionManager getTransactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(this.getDataSource());
		return transactionManager;
	}



	@Bean("taskExecutor")
	public TaskExecutorFactoryBean getTaskExecutorFactoryBean() {
		TaskExecutorFactoryBean taskExecutorFactoryBean = new TaskExecutorFactoryBean();
		taskExecutorFactoryBean.setPoolSize("10");
		taskExecutorFactoryBean.setQueueCapacity(200);
		return taskExecutorFactoryBean;
	}

}
