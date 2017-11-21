/**   
 * @Title: CompositeService.java 
 * @Package com.denny.course.service 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月24日 下午5:28:00 
 * @version V1.0   
 */
package com.denny.task01.common.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.denny.common.IBaseService;
import com.denny.task01.common.domain.Org;
import com.denny.task01.common.domain.User;
import com.denny.task01.common.jdbc.CustomJdbcTemplate;

/**
 * @ClassName: CompositeService
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @param <User>
 * @date 2017年10月05日 下午5:28:00
 * 
 */
@Service("compositeService")
public class CompositeService {

	private final static Logger logger = LoggerFactory.getLogger(CompositeService.class);

	@Autowired
	private CustomJdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("userService")
	private IBaseService<User> userService;

	@Autowired
	@Qualifier("orgService")
	private IBaseService<Org> orgService;

	@Transactional
	public void saveUserAndOrg(User user, Org org) {
		this.userService.save(user);
		jdbcTemplate.update("insert into T_ORG (ORG_NAME, ORG_ADDRESS) values (?, ?)",
				new Object[] {org.getOrgName(), org.getOrgAddress() });
	}

}
