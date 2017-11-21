package com.denny.test;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ApplicationTests {

	@Autowired
	private UserDetailsManager userDetailsManager;

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void contextLoads() {
	}

	@Test
	@Ignore
	public void testUserAndAuthority() {
		Collection<SimpleGrantedAuthority> authorityList = new ArrayList<SimpleGrantedAuthority>();
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority("user");
		authorityList.add(authority);
		User user = new User("zhangkui", "123456", authorityList);
		userDetailsManager.createUser(user);
	}

	@Test
	@Sql(scripts = { "classpath:test/homework01_init.sql" })
	public void testHomework_01() throws Exception {
		mockMvc.perform(get("/manager/index.html")).andExpect(status().isExpectationFailed())
				.andDo(MockMvcResultHandlers.print());
	}
}
