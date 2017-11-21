/**   
 * @Title: ProductionConfig.java 
 * @Package com.denny.spring.production 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月9日 上午10:37:17 
 * @version V1.0   
 */
package com.denny.spring.production;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

/** 
 * @ClassName: ProductionConfig 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月9日 上午10:37:17 
 *  
 */
@Configuration
@Profile("prod")
@PropertySource("classpath:prod.properties")
public class ProductionConfig {
	
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

	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	
	@Bean(name = "transactionManager")
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(this.getDataSource());
		return transactionManager;
	}
}
