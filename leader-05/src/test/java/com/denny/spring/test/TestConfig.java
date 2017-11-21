/**   
 * @Title: TestConfig.java 
 * @Package com.denny.spring.test 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月9日 上午11:11:17 
 * @version V1.0   
 */
package com.denny.spring.test;

import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.mockito.internal.stubbing.answers.DoesNothing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** 
 * @ClassName: TestConfig 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月9日 上午11:11:17 
 *  
 */
@Configuration
@Profile("test")
public class TestConfig {
	
	private final static Logger logger = LoggerFactory.getLogger(TestConfig.class);

	@Bean("dataSource")
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource dataSource = mock(DriverManagerDataSource.class);
		Connection conn = mock(Connection.class);
		try {
			//java8 Lambda表达式调用函数是接口方法
			when(dataSource.getConnection()).then(m -> {logger.info("获取数据库连接"); return conn;});
			doAnswer(m -> {logger.info("设置自动提交为:false"); return new DoesNothing();}).when(conn).setAutoCommit(false);
			doAnswer(m -> {logger.info("设置自动提交为:true"); return new DoesNothing();}).when(conn).setAutoCommit(true);
			doAnswer(m -> {logger.info("事务提交"); return new DoesNothing();}).when(conn).commit();
			doAnswer(m -> {logger.info("事务回滚"); return new DoesNothing();}).when(conn).rollback();
			doAnswer(m -> {logger.info("数据库连接关闭"); return new DoesNothing();}).when(conn).close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataSource;
	}
	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);
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
