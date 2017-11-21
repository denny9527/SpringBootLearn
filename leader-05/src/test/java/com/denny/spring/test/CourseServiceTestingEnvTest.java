/**   
 * @Title: CourseServiceTestingEnvTest.java 
 * @Package com.denny.spring.test 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月9日 下午6:04:15 
 * @version V1.0   
 */
package com.denny.spring.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestExecutionListeners.MergeMode;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.denny.course.domain.Course;
import com.denny.course.query.CourseQuery;
import com.denny.course.service.CourseService;
import com.denny.spring.config.ApplicationConfig;

/** 
 * @ClassName: CourseServiceTestingEnvTest 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月9日 下午6:04:15 
 *  
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@ActiveProfiles("test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners(listeners = {MockTestListener.class}, mergeMode = MergeMode.MERGE_WITH_DEFAULTS)
@Transactional
public class CourseServiceTestingEnvTest {
	private final static Logger logger = LoggerFactory.getLogger(CourseServiceTestingEnvTest.class);
	@Autowired
	private CourseService courseService;

	@Test
	public void test101_queryAllCourse() {
		CourseQuery query = new CourseQuery();
		List<Course> courseList = courseService.queryList(query);
		logger.info("查询所有课程数据,返还模拟数据集:"+courseList.toString());
		assertEquals(2l, courseList.size());
	}
	
	@Test
	public void test102_getCourseById() {
		Course course = courseService.getById(73l);
		logger.info("根据ID获取课程数据,返还模拟数据集:"+course.toString());
		assertEquals("物理", course.getName());
		assertEquals(new BigDecimal("95.00"), course.getMark());
	}

	@BeforeClass
	public static void beforeTestCase() {
		logger.info("测试环境Mork数据库操作测试开始!");
	}
	
	@AfterClass
	public static void afterTestCase() {
		logger.info("测试环境Mork数据库操作测试结束!");
	}
}


