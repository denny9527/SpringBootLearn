/**   
 * @Title: SpringTransactionDemo3.java 
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
 * @ClassName: SpringTransactionDemo3
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年9月24日 下午4:25:08
 * 
 */
public class SpringTransactionDemo3 {

	private static void clearData(CustomJdbcTemplate jdbcTemplate) {
		jdbcTemplate.update("delete from USER", new Object[] {});
		jdbcTemplate.update("delete from ORG", new Object[] {});
	}

	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.denny");
		CustomJdbcTemplate jdbcTemplate = (CustomJdbcTemplate) context.getBean("jdbcTemplate");
		clearData(jdbcTemplate);
		CompositeService compositeService = context.getBean(CompositeService.class);
		User user = new User(101l, "张明", "1234566", "1", new Date());
		Org org = new Org(101l, "清华大学", "中国北京");
		compositeService.saveUserAndOrg(user, org);
	}
}
