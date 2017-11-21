/**   
 * @Title: DataSourceConfig.java 
 * @Package com.denny.config 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年8月25日 下午5:09:22 
 * @version V1.0   
 */
package com.denny.config;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;
import com.denny.properties.JDBCProperties;

/**
 * @ClassName: DataSourceConfig
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年8月25日 下午5:09:22
 * 
 */
@Configuration
@EnableConfigurationProperties({ JDBCProperties.class })
public class DataSourceConfig {

	private static Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);
	
	@Autowired
	private JDBCProperties jdbcProperties;

	@Bean(name = "dataSource", destroyMethod = "close")
	public DruidDataSource getDataSource() {
		logger.info(jdbcProperties.toString());
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setDriverClassName(jdbcProperties.getDriverClassName());
		druidDataSource.setUrl(jdbcProperties.getUrl());
		druidDataSource.setUsername(jdbcProperties.getUserName());
		druidDataSource.setPassword(jdbcProperties.getPassword());
		druidDataSource.setMaxActive(100);
		druidDataSource.setMaxWait(1000);
		druidDataSource.setTestWhileIdle(true);
		druidDataSource.setValidationQuery("select 1 from dual");
		druidDataSource.setInitialSize(10);
		druidDataSource.setTestOnBorrow(false);
		druidDataSource.setTestOnReturn(false);
		druidDataSource.setTimeBetweenEvictionRunsMillis(60000);
		druidDataSource.setMinEvictableIdleTimeMillis(25200000);
		druidDataSource.setRemoveAbandoned(true);
		druidDataSource.setRemoveAbandonedTimeout(1800);
		druidDataSource.setLogAbandoned(true);
		try {
			druidDataSource.setFilters("stat");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		druidDataSource.setDefaultAutoCommit(true);
		return druidDataSource;

	}

}
