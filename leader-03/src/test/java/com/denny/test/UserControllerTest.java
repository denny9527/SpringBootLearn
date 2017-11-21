/**   
 * @Title: UserControllerTest.java 
 * @Package com.denny.test 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年8月27日 下午3:25:36 
 * @version V1.0   
 */
package com.denny.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.iterableWithSize;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Date;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSON;
import com.denny.Application;
import com.denny.user.common.bean.UserInfo;
import com.denny.user.common.query.UserInfoQuery;
import com.denny.utils.MD5Util;
import com.denny.utils.UUIDUtil;

/**
 * @ClassName: UserControllerTest
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年8月27日 下午3:25:36
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class }) // 自动扫描@SpringBootApplication;或者指定Configuration
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 根据方法名排序指定测试方法执行顺序
public class UserControllerTest {

	private static final Logger logger = LoggerFactory.getLogger(UserControllerTest.class);

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	// private HttpMessageConverter mappingJackson2HttpMessageConverter;

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}

	@Test
	//@Ignore
	public void test001() throws Exception {
		logger.info("测试用户创建");
		UserInfo userInfo = new UserInfo();
		userInfo.setId(100L);
		userInfo.setUserId(UUIDUtil.generateUUID());
		userInfo.setUserName("张海");
		userInfo.setPassword(MD5Util.encrypt("123456"));
		userInfo.setRegdate(new Date());
		mockMvc.perform(post("/user_manage/create_user").content(JSON.toJSONString(userInfo))
				.contentType(contentType))
				.andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());

	}

	@Test
	//@Ignore
	public void test002() throws Exception {
		logger.info("测试用户信息查询");
		UserInfoQuery userInfoQuery = new UserInfoQuery();
		userInfoQuery.setUserName("张海");
		mockMvc.perform(
				post("/user_manage/query_users").content(JSON.toJSONString(userInfoQuery)).contentType(contentType))
				.andExpect(status().isOk()).andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$[0]['userName']", containsString("张海"))).andDo(MockMvcResultHandlers.print());
	}

	@Test
	//@Ignore
	public void test003() throws Exception {
		logger.info("测试注销用户");
		Long id = 100l;
		mockMvc.perform(get("/user_manage/disable_user/" + id.toString())).andExpect(status().isOk())
				.andExpect(content().contentType(contentType)).andExpect(jsonPath("$.result", containsString("用户注销成功")))
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	//@Ignore
	public void test004() throws Exception {
		logger.info("测试删除用户");
		Long id = 100l;
		mockMvc.perform(delete("/user_manage/delete_user/" + id.toString())).andExpect(status().isOk())
				.andExpect(content().contentType(contentType)).andExpect(jsonPath("$.result", containsString("用户删除成功")))
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void test005() throws Exception {
		logger.info("测试用户登录");
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName("宋江");
		userInfo.setPassword("123456");
		mockMvc.perform(post("/user_manage/login").content(JSON.toJSONString(userInfo)).contentType(contentType))
				.andExpect(status().isOk()).andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$.result", containsString("用户登录成功"))).andDo(MockMvcResultHandlers.print());
	}

}
