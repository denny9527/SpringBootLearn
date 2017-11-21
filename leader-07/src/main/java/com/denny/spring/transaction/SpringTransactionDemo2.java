/**   
 * @Title: SpringTransactionDemo1.java 
 * @Package com.denny.spring.transaction 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月24日 上午9:25:08 
 * @version V1.0   
 */
package com.denny.spring.transaction;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.denny.course.common.IBaseService;
import com.denny.course.domain.User;

/**
 * @ClassName: SpringTransactionDemo1
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年9月24日 上午9:25:08
 * 
 */
public class SpringTransactionDemo2 {

	private final static Logger logger = LoggerFactory.getLogger(SpringTransactionDemo2.class);

	private static void clearData(CustomJdbcTemplate jdbcTemplate) {
		jdbcTemplate.update("delete from USER", new Object[] {});
		jdbcTemplate.update("delete from ORG", new Object[] {});
	}

	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.denny");
		CustomJdbcTemplate jdbcTemplate = (CustomJdbcTemplate)context.getBean("jdbcTemplate");
		clearData(jdbcTemplate);
		IBaseService<User> userService = (IBaseService<User>)context.getBean("userService");
		User user = new User(101l, "张明", "1234566", "1", new Date());
		userService.save(user);
	}
}
