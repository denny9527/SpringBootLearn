/**   
 * @Title: CustomAopServiceTest.java 
 * @Package com.denny.course.test 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月17日 上午11:02:01 
 * @version V1.0   
 */
package com.denny.course.test;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.denny.course.common.BaseService;
import com.denny.course.common.IBaseService;
import com.denny.course.custom.aop.AopProxyType;
import com.denny.course.custom.aop.CustomAopApplicationConfig;
import com.denny.course.custom.aop.ProxyFactory;
import com.denny.course.custom.aop.TransactionManageConfig;
import com.denny.course.domain.Org;
import com.denny.course.domain.User;
import com.denny.course.service.OrgService;
import com.denny.course.service.UserService;
import com.denny.course.spring.aop.ApplicationConfig;
import com.denny.course.spring.aop.ConnectionManager;
import com.denny.course.spring.aop.CustomJdbcTemplate;

/**
 * @ClassName: CustomAopServiceTest
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年9月17日 上午11:02:01
 * 
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { CustomAopApplicationConfig.class })
public class CustomAopServiceTest {

	@Autowired
	private CustomJdbcTemplate jdbcTemplate;

	private IBaseService<User> userServiceProxy;

	private IBaseService<Org> orgServiceProxy;

	@Autowired
	private UserService userServiceTarget;

	@Autowired
	private OrgService orgServiceTarget;

	@Autowired
	private ConnectionManager connectionManager;

	@Autowired
	private TransactionManageConfig transactionManageConfig;

	@PostConstruct
	public void setServiceProxy() {
		ProxyFactory proxyFactory1 = new ProxyFactory(userServiceTarget);
		proxyFactory1.setAdviceList(transactionManageConfig.getAdviceList());
		userServiceProxy = (IBaseService<User>) proxyFactory1.getProxy(AopProxyType.JDK_DYNAMIC_PROXY);

		ProxyFactory proxyFactory2 = new ProxyFactory(orgServiceTarget);
		proxyFactory2.setAdviceList(transactionManageConfig.getAdviceList());
		orgServiceProxy = (IBaseService<Org>) proxyFactory2.getProxy(AopProxyType.CGLIB_PROXY);
	}

	@Before
	public void initData() {
		jdbcTemplate.update("delete from USER", new Object[] {});
		jdbcTemplate.update("delete from ORG", new Object[] {});
		connectionManager.closeConnection();
		jdbcTemplate.update("insert into USER(ID, NAME, PASSWORD, ENABLED, REG_TIME) values(?, ?, ?, ?, ?)",
				new Object[] { 100, "张奎", "123456", "1", new Date() });

		jdbcTemplate.update("insert into ORG(ID, ORG_NAME, ORG_ADDRESS) values(?, ?, ?)",
				new Object[] { 100, "中科院", "中国北京" });
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
			userServiceProxy.save(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	//@Ignore
	public void testDelete() {
		userServiceProxy.delete(1l);
	}

	@Test
	//@Ignore
	public void testQuery() {
		User user = new User();
		Org org = new Org();
		userServiceProxy.queryList(user);
		orgServiceProxy.queryList(org);
	}

}

