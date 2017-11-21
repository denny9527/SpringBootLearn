/**   
 * @Title: ApplicationConfig.java 
 * @Package com.denny.task01.config 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年10月6日 上午11:27:21 
 * @version V1.0   
 */
package com.denny.task04.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;

import com.denny.task01.common.jdbc.CustomJdbcTemplate;
import com.denny.task01.common.service.CompositeService;
import com.denny.task04.spring.CustomTransactionManagement;
import com.denny.task04.spring.CustomTransactionManagement.TransactionAttribute;

/**
 * @ClassName: ApplicationConfig
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年10月6日 上午11:27:21
 * 
 */
@Configuration
@CustomTransactionManagement(expression = "execution(* com.denny..*Service.*(..))", transactionAttributes = {
		@TransactionAttribute(methodName = "get*", propagation = Propagation.SUPPORTS, readOnly = true),
		@TransactionAttribute(methodName = "query*", propagation = Propagation.SUPPORTS, readOnly = true),
		@TransactionAttribute(methodName = "save*"), @TransactionAttribute(methodName = "update*"),
		@TransactionAttribute(methodName = "delete*") })
@ComponentScan(basePackages = { "com.denny.task04", "com.denny.task01", "com.denny.common" }, excludeFilters = {
		@Filter(type = FilterType.ASSIGNABLE_TYPE, value = com.denny.task01.config.ApplicationConfig.class),
		@Filter(type = FilterType.ASSIGNABLE_TYPE, value = CompositeService.class),
		@Filter(type = FilterType.ASSIGNABLE_TYPE, value = CustomJdbcTemplate.class) })
@PropertySource("classpath:jdbc.properties")
@MapperScan("com.denny.task01.common.dao")
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

}
