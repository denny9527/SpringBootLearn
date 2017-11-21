/**   
 * @Title: CourseServiceProdEnvTest.java 
 * @Package com.denny.spring.test 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月9日 下午3:22:49 
 * @version V1.0   
 */
package com.denny.spring.test;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.denny.course.domain.Course;
import com.denny.course.query.CourseQuery;
import com.denny.course.service.CourseService;
import com.denny.spring.config.ApplicationConfig;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * @ClassName: CourseServiceProdEnvTest
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年9月9日 下午3:22:49
 * 
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@ActiveProfiles("prod")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional//默认rollback
public class CourseServiceProdEnvTest {
	private final static Logger logger = LoggerFactory.getLogger(CourseServiceProdEnvTest.class);
	@Autowired
	private CourseService courseService;

	@Test
	@Sql(scripts = {
			"classpath:test/prod_init_course.sql" })
	public void test101_queryAllCourse() {
		CourseQuery query = new CourseQuery();
		List<Course> courseList = courseService.queryList(query);
		logger.info("查询所有课程信息结果:"+courseList);
		assertEquals(8l, courseList.size());
	}

	@Test
	@Sql(scripts = {
			"classpath:test/prod_init_course.sql" })
	public void test102_getCourseById() {
		Course course = courseService.getById(73l);
		logger.info("根据ID获取课程信息结果:"+course);
		assertEquals("物理", course.getName());
		assertEquals(new BigDecimal("95.00"), course.getMark());
	}

	@BeforeClass
	public static void beforeTestCase() {
		logger.info("生产环境数据库操作测试开始!");
	}

	@AfterClass
	public static void afterTestCase() {
		logger.info("生产环境数据库操作测试结束!");
	}
}
