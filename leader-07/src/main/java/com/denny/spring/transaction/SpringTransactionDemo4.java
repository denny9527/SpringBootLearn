/**   
 * @Title: SpringTransactionDemo4.java 
 * @Package com.denny.spring.transaction 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月24日 下午4:25:08 
 * @version V1.0   
 */
package com.denny.spring.transaction;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.denny.course.common.IBaseService;
import com.denny.course.domain.Org;
import com.denny.course.domain.User;
import com.denny.course.service.CompositeService;

/** 
 * @ClassName: SpringTransactionDemo4 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月24日 下午4:25:08 
 *  
 */
public class SpringTransactionDemo4 {

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

