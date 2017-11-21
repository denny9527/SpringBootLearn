/**   
 * @Title: CompositeService.java 
 * @Package com.denny.course.service 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月24日 下午5:28:00 
 * @version V1.0   
 */
package com.denny.course.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.denny.common.utils.ThreadLocalUtil;
import com.denny.course.common.IBaseService;
import com.denny.course.domain.Org;
import com.denny.course.domain.User;
import com.denny.spring.transaction.CustomJdbcTemplate;

/**
 * @ClassName: CompositeService
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @param <User>
 * @date 2017年9月24日 下午5:28:00
 * 
 */
@Service("compositeService")
public class CompositeService {

	private final static Logger logger = LoggerFactory.getLogger(CompositeService.class);
	
	@Autowired
	private CustomJdbcTemplate jdbcTemplate;

	@Autowired
	private TransactionTemplate transactionTemplate;

	@Autowired
	TaskExecutor taskExecutor;

	@Autowired
	@Qualifier("userService")
	private IBaseService<User> userService;

	@Autowired
	@Qualifier("orgService")
	private IBaseService<Org> orgService;

	@Autowired
	private PlatformTransactionManager transactionManager;

	@Transactional
	public void saveUserAndOrg(User user, Org org) throws Exception {
		logger.info("保存用户和机构信息方法(saveUserAndOrg)执行开始!");
		userService.save(user);
		orgService.save(org);
		logger.info("保存用户和机构信息方法(saveUserAndOrg)执行结束!");
	}

	@Transactional
	public void saveAndDeleteUser(final User user, final Long id) throws Exception {
		logger.info("当前线程:" + Thread.currentThread().getName() + "执行开始!");
		userService.save(user);
		taskExecutor.execute(() -> {
			logger.info("当前线程:" + Thread.currentThread().getName() + "执行开始!");
			userService.delete(id);
		});
	}

	@Transactional
	public void saveAndUpdateUser(User newUser, final User updateUser) {
		jdbcTemplate.update("insert into USER(ID, NAME, PASSWORD, ENABLED, REG_TIME) values(?, ?, ?, ?, ?)",
				new Object[] { newUser.getId(), newUser.getName(), newUser.getPassword(), newUser.getEnabled(),
						newUser.getRegTime() });
		transactionTemplate.execute((TransactionStatus status) -> {
			return jdbcTemplate.update("update USER set enabled = ? where id = ?",
					new Object[] { updateUser.getEnabled(), updateUser.getId() });
		});

	}

}
