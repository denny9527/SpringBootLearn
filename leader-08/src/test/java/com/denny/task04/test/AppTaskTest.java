/**   
 * @Title: AppTaskTest.java 
 * @Package com.denny.task01.test 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年10月6日 下午12:35:38 
 * @version V1.0   
 */
package com.denny.task04.test;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.QueryHint;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.denny.task04.config.ApplicationConfig;
import com.denny.common.IBaseService;
import com.denny.task01.common.domain.User;


/** 
 * @ClassName: AppTaskTest 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年10月6日 下午12:35:38 
 *  
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppTaskTest {

	@Autowired
	IBaseService<User> userService;
	
	@Sql(scripts = {
	"classpath:test/init_data.sql" })
	@Test
	public void test01() {
		User user = userService.getById(100l);
		Assert.assertNotNull("用户信息存在", user);
	}
	
	@Test
	public void test02() {
		User user = new User(100l, null, null, "0", null);
		userService.update(user);
	}
	
	@Test
	public void test03() {
		User user = new User(null, "张明", "123456", "1", new Date());
		userService.save(user);
	}

}
