/**   
 * @Title: SpringTransactionDemo5.java 
 * @Package com.denny.spring.transaction 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月25日 上午6:30:26 
 * @version V1.0   
 */
package com.denny.spring.transaction;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.denny.course.domain.User;
import com.denny.course.service.CompositeService;

/**
 * @ClassName: SpringTransactionDemo5
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年9月25日 上午6:30:26
 * 
 */
public class SpringTransactionDemo5 {

	private static void clearData(CustomJdbcTemplate jdbcTemplate) {
		jdbcTemplate.update("delete from USER", new Object[] {});
		jdbcTemplate.update("delete from ORG", new Object[] {});
		jdbcTemplate.update("insert into USER(ID, NAME, PASSWORD, ENABLED, REG_TIME) values(?, ?, ?, ?, ?)",
				new Object[] { 100l, "王海", "2345678", "1", new Date() });
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.denny");
		CustomJdbcTemplate jdbcTemplate = (CustomJdbcTemplate) context.getBean("jdbcTemplate");
		CompositeService compositeService = (CompositeService) context.getBean(CompositeService.class);
		clearData(jdbcTemplate);
		User newUser = new User(101l, "张明", "1234566", "1", new Date());
		User updateUser = new User(100l, null, null, "0", null);
		compositeService.saveAndUpdateUser(newUser, updateUser);
	}

}

