/**   
 * @Title: UserInfoServiceTest.java 
 * @Package com.denny.test 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年8月26日 下午9:14:09 
 * @version V1.0   
 */
package com.denny.test;


import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.denny.Application;
import com.denny.user.common.bean.UserInfo;
import com.denny.user.common.query.UserInfoQuery;
import com.denny.user.common.service.IUserInfoService;
import com.denny.utils.MD5Util;
import com.denny.utils.UUIDUtil;

import junit.framework.TestCase;

/** 
 * @ClassName: UserInfoServiceTest 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年8月26日 下午9:14:09 
 *  
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class}) //自动扫描@SpringBootApplication;或者指定Configuration
@FixMethodOrder(MethodSorters.NAME_ASCENDING) //根据方法名排序指定测试方法执行顺序
public class UserInfoServiceTest extends TestCase {

	private static final Logger logger = LoggerFactory
			.getLogger(UserInfoServiceTest.class);

	@Autowired
	private IUserInfoService userInfoService;
	
	@Test
	//@Ignore
	public void test001() {
		logger.info("测试用户创建");
		UserInfo userInfo = new UserInfo();
		userInfo.setId(100l);
		userInfo.setUserId(UUIDUtil.generateUUID());
		userInfo.setUserName("张奎");
		userInfo.setPassword(MD5Util.encrypt("123456"));
		userInfo.setRegdate(new Date());
		Long id = userInfoService.save(userInfo);
		logger.info("用户主键ID:"+id);
		Assert.assertNotNull("创建用户返还ID不为空, ID="+id, id);
	}
	
	@Test
	//@Ignore
	public void test002() {
		logger.info("测试根据主键ID获取用户信息");
		UserInfo userInfo = userInfoService.getById(100l);
		logger.info("用户信息:"+userInfo.toString());
		Assert.assertNotNull("根据主键ID获取用户信息不为空", userInfo.getUserName());
	}
	
	@Test
	//@Ignore
	public void test003() {
		logger.info("测试查询用户信息数量");
		UserInfoQuery query = new UserInfoQuery();
		query.setUserName("张奎");
		Long count = userInfoService.queryCount(query);
		logger.info("用户信息数量:"+count);
		Assert.assertEquals(1, count.longValue());
	}
	
	@Test
	//@Ignore
	public void test004() {
		logger.info("测试查询用户信息列表");
		UserInfoQuery query = new UserInfoQuery();
		query.setUserName("张奎");
		List<UserInfo> userInfoList = userInfoService.queryList(query);
		logger.info("用户信息列表:"+userInfoList);
		Assert.assertEquals(1, userInfoList.size());
	}
	
	@Test
	//@Ignore
	public void test005() {
		logger.info("测试根据主键ID删除用户信息");
		int count = userInfoService.deleteById(100l);
		logger.info("根据主键ID删除用户信息返还影响行数:"+count);
		Assert.assertEquals(1, count);
	}
	
	@Test
	//@Ignore
	public void test006() {
		logger.info("测试分页查询用户信息列表");
		UserInfoQuery query = new UserInfoQuery();
		//query.setUserName("李明");
		query.setCurrentPage(8);
		query.setPageSize(2);
		List<UserInfo> userInfoList = userInfoService.queryWithPage(query);
		logger.info("用户信息列表:"+userInfoList);
		Assert.assertEquals(1, userInfoList.size());
	}

}
