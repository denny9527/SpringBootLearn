/**   
 * @Title: MockTestListener.java 
 * @Package com.denny.spring.test 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月9日 下午6:10:08 
 * @version V1.0   
 */
package com.denny.spring.test;

import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

import com.denny.course.domain.Course;
import com.mysql.jdbc.PreparedStatement;

import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

/**
 * @ClassName: MockTestListener
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年9月9日 下午6:10:08
 * 
 */
public class MockTestListener extends AbstractTestExecutionListener {
	
	private final static Logger logger = LoggerFactory.getLogger(MockTestListener.class);

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	public MockTestListener() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc) <p>Title: beforeTestClass</p> <p>Description: </p>
	 * 
	 * @param testContext
	 * 
	 * @throws Exception
	 * 
	 * @see org.springframework.test.context.support.AbstractTestExecutionListener#
	 * beforeTestClass(org.springframework.test.context.TestContext)
	 */
	@Override
	public void beforeTestClass(TestContext testContext) throws Exception {
		super.beforeTestClass(testContext);
	}

	/*
	 * (non-Javadoc) <p>Title: prepareTestInstance</p> <p>Description: </p>
	 * 
	 * @param testContext
	 * 
	 * @throws Exception
	 * 
	 * @see org.springframework.test.context.support.AbstractTestExecutionListener#
	 * prepareTestInstance(org.springframework.test.context.TestContext)
	 */
	@Override
	public void prepareTestInstance(TestContext testContext) throws Exception {
		super.prepareTestInstance(testContext);
	}

	/*
	 * (non-Javadoc) <p>Title: beforeTestMethod</p> <p>Description: </p>
	 * 
	 * @param testContext
	 * 
	 * @throws Exception
	 * 
	 * @see org.springframework.test.context.support.AbstractTestExecutionListener#
	 * beforeTestMethod(org.springframework.test.context.TestContext)
	 */
	@Override
	public void beforeTestMethod(TestContext testContext) throws Exception {
		super.beforeTestMethod(testContext);
		String methodName = testContext.getTestMethod().getName();
		JdbcTemplate jdbcTemplate = testContext.getApplicationContext().getBean(JdbcTemplate.class);
		DataSource dataSource = testContext.getApplicationContext().getBean(DataSource.class);
		Connection conn = mock(Connection.class);
		Statement statement = mock(Statement.class);
		when(dataSource.getConnection()).thenReturn(conn);
		when(conn.createStatement()).thenReturn(statement);
		if (methodName.equals("test101_queryAllCourse")) { 
			 List<Course> result = mock(ArrayList.class);
			 Course course1 = new Course(69l, "语文", new BigDecimal("100.00"));
			 Course course2 = new Course(73l, "物理", new BigDecimal("95.00"));
			 result.add(course1);
			 result.add(course2);
			 when(result.size()).thenReturn(2);
			 when(result.toString()).thenReturn(course1.toString() + course2.toString());
			 // 模拟JdbcTemplate查询方法返还Mock结果集
			 when(jdbcTemplate.query(anyString(), any(Object[].class),
			 any(RowMapper.class))).thenReturn(result);
		} else if (methodName.equals("test102_getCourseById")) {
			 Course course = mock(Course.class);
			 // 模拟JdbcTemplate查询方法返还Mock结果集
			 when(course.getName()).thenReturn("物理");
			 when(course.getMark()).thenReturn(new BigDecimal("95.00"));	
			 when(course.toString()).thenReturn(new Course(73l, "物理", new BigDecimal("95.00")).toString());
			 when(jdbcTemplate.queryForObject(anyString(), eq(new Object[] { 73l }), any(RowMapper.class))).thenReturn(course);	 
		}

	}

	/*
	 * (non-Javadoc) <p>Title: afterTestMethod</p> <p>Description: </p>
	 * 
	 * @param testContext
	 * 
	 * @throws Exception
	 * 
	 * @see org.springframework.test.context.support.AbstractTestExecutionListener#
	 * afterTestMethod(org.springframework.test.context.TestContext)
	 */
	@Override
	public void afterTestMethod(TestContext testContext) throws Exception {
		super.afterTestMethod(testContext);
	}

	/*
	 * (non-Javadoc) <p>Title: afterTestClass</p> <p>Description: </p>
	 * 
	 * @param testContext
	 * 
	 * @throws Exception
	 * 
	 * @see org.springframework.test.context.support.AbstractTestExecutionListener#
	 * afterTestClass(org.springframework.test.context.TestContext)
	 */
	@Override
	public void afterTestClass(TestContext testContext) throws Exception {
		super.afterTestClass(testContext);
	}

}
