/**   
 * @Title: ApplicationConfig.java 
 * @Package com.denny.task01.config 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年10月6日 上午11:27:21 
 * @version V1.0   
 */
package com.denny.task02.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.scheduling.config.TaskExecutorFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/** 
 * @ClassName: ApplicationConfig 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年10月6日 上午11:27:21 
 *  
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.denny.task02", "com.denny.common"})
@PropertySource("classpath:jdbc.properties")
@MapperScan("com.denny.task02.common.dao")
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
	
	@Bean(name = "transactionManager")
	public PlatformTransactionManager getTransactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(getDataSource());
		return transactionManager;
	}
	
	@Bean("mybatisSqlSessionFactory")
	public SqlSessionFactory getMyBatisSqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(getDataSource());
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean("taskExecutor")
	public TaskExecutorFactoryBean getTaskExecutorFactoryBean() {
		TaskExecutorFactoryBean taskExecutorFactoryBean = new TaskExecutorFactoryBean();
		taskExecutorFactoryBean.setPoolSize("10");
		taskExecutorFactoryBean.setQueueCapacity(200);
		return taskExecutorFactoryBean;
	}
}
