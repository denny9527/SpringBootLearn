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
import org.springframework.core.task.TaskExecutor;

import com.denny.common.utils.ThreadLocalUtil;
import com.denny.course.common.BaseService;
import com.denny.course.common.IBaseService;
import com.denny.course.domain.Org;
import com.denny.course.domain.User;
import com.denny.course.service.CompositeService;
import com.denny.course.service.OrgService;
import com.denny.course.service.UserService;

/**
 * @ClassName: SpringTransactionDemo1
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年9月24日 上午9:25:08
 * 
 */
public class SpringTransactionDemo1 {

	private final static Logger logger = LoggerFactory.getLogger(SpringTransactionDemo1.class);

	private static void multiThreadBizExec(AnnotationConfigApplicationContext context) {
		final IBaseService<User> userService = (IBaseService<User>) context.getBean("userService");
		final IBaseService<Org> orgService = (IBaseService<Org>) context.getBean("orgService");
		TaskExecutor taskExecutor = (TaskExecutor) context.getBean("taskExecutor");
		taskExecutor.execute(new Runnable() {
			@Override
			public void run() {
				logger.info("当前线程:" + Thread.currentThread().getName() + "执行开始!");
				User user = new User(101l, "张明", "1234566", "1", new Date());
				try {
					userService.save(user);
					Thread.currentThread().sleep(1000);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// ThreadLocalUtil.dumphreadLocals();
				logger.info("当前线程:" + Thread.currentThread().getName() + "执行结束!");
			}
		});
		taskExecutor.execute(new Runnable() {
			@Override
			public void run() {
				logger.info("当前线程:" + Thread.currentThread().getName() + "执行开始!");
				Org org = new Org();
				org.setId(101l);
				org.setOrgName("中科院");
				org.setOrgAddress("中国北京");
				try {
					orgService.save(org);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// ThreadLocalUtil.dumphreadLocals();
				logger.info("当前线程:" + Thread.currentThread().getName() + "执行结束!");
			}
		});
	}

	private static void clearAndInitData(CustomJdbcTemplate jdbcTemplate) {
		jdbcTemplate.update("delete from USER", new Object[] {});
		jdbcTemplate.update("delete from ORG", new Object[] {});
		jdbcTemplate.update("insert into USER(ID, NAME, PASSWORD, ENABLED, REG_TIME) values(?, ?, ?, ?, ?)",
				new Object[] { 100l, "王丹", "234567", "1", new Date() });
	}

	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.denny");
		CustomJdbcTemplate jdbcTemplate = (CustomJdbcTemplate) context.getBean("jdbcTemplate");
		clearAndInitData(jdbcTemplate);
		CompositeService compositeService = (CompositeService) context.getBean(CompositeService.class);
		compositeService.saveAndDeleteUser(new User(101l, "张明", "1234566", "1", new Date()), 100l);
		context.registerShutdownHook();
		context.close();
	}
}
