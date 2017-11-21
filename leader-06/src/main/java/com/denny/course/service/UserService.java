/**   
 * @Title: UserService.java 
 * @Package com.denny.common.user 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月3日 下午9:44:32 
 * @version V1.0   
 */
package com.denny.course.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.denny.course.common.BaseService;
import com.denny.course.domain.User;

/** 
 * @ClassName: UserService 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月3日 下午9:44:32 
 *  
 */
@Service("userService")
public class UserService extends BaseService<User> {
	
	private final static Logger logger = LoggerFactory.getLogger(UserService.class);

//	@Override
//	public int save(User t) throws Exception {
//		super.save(t);
//		throw new Exception("抛出非RuntimeException异常触发事务提交！");
//	}
	
	@Override
	public int save(User t) {
		super.save(t);
		throw new RuntimeException("抛出RuntimeException异常！");
	}

}
