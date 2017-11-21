/**   
 * @Title: ServiceTest.java 
 * @Package com.denny.course.test 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月17日 上午11:02:01 
 * @version V1.0   
 */
package com.denny.course.test;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.denny.course.common.BaseService;
import com.denny.course.common.IBaseService;
import com.denny.course.domain.Org;
import com.denny.course.domain.User;
import com.denny.course.service.OrgService;
import com.denny.course.service.UserService;
import com.denny.course.spring.aop.ApplicationConfig;
import com.denny.course.spring.aop.ConnectionManager;
import com.denny.course.spring.aop.CustomJdbcTemplate;

/**
 * @ClassName: ServiceTest
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年9月17日 上午11:02:01
 * 
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
public class ServiceTest {

	@Autowired
	@Qualifier("userService")
	private IBaseService<User> userService;
	
	@Autowired
	@Qualifier("orgService")
	private IBaseService<Org> orgService;

	@Autowired
	private CustomJdbcTemplate jdbcTemplate;
	
	@Autowired
	private ConnectionManager connectionManager;

	@Before
	public void initData() {
		jdbcTemplate.update("delete from USER", new Object[] {});
		jdbcTemplate.update("delete from ORG", new Object[] {});
		connectionManager.closeConnection();
		jdbcTemplate.update("insert into USER(ID, NAME, PASSWORD, ENABLED, REG_TIME) values(?, ?, ?, ?, ?)",
				new Object[] {100, "张奎", "123456", "1", new Date()});	
		jdbcTemplate.update("insert into ORG(ID, ORG_NAME, ORG_ADDRESS) values(?, ?, ?)",
				new Object[] {100, "中科院", "中国北京"});
		connectionManager.closeConnection();
	}

//	@After
//	public void clearData() {
//		jdbcTemplate.update("delete from USER", new Object[] {});
//		jdbcTemplate.update("delete from ORG", new Object[] {});
//		connectionManager.closeConnection();
//	}

	@Test
	public void testSave() {
		User user = new User();
		user.setId(101l);
		user.setName("张明");
		user.setPassword("1234566");
		user.setRegTime(new Date());
		user.setEnabled("1");
		try {
			userService.save(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		userService.delete(1l);
	}
	
	@Test
	public void testQuery() {
		User user = new User();
		Org org = new Org();
		userService.queryList(user);
		orgService.queryList(org);
		
	}

}
