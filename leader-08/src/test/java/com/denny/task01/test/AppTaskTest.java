/**   
 * @Title: AppTaskTest.java 
 * @Package com.denny.task01.test 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年10月6日 下午12:35:38 
 * @version V1.0   
 */
package com.denny.task01.test;

import java.util.Date;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.denny.task01.common.domain.Org;
import com.denny.task01.common.domain.User;
import com.denny.task01.common.service.CompositeService;
import com.denny.task01.config.ApplicationConfig;


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
	private CompositeService compositeService;

	@Sql(scripts = {
	"classpath:test/init_data.sql" })
	@Test
	public void testSaveUserAndOrg() {
		User user = new User(null, "张明海", "123456", "1", new Date());
		Org org = new Org(null, "武汉第二小学", "湖北武汉");
		compositeService.saveUserAndOrg(user, org);
	}
}
