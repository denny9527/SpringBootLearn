/**   
 * @Title: UserService.java 
 * @Package edu.ldcollege.service 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年10月14日 下午4:10:24 
 * @version V1.0   
 */
package edu.ldcollege.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.ldcollege.dao.IUserDao;
import edu.ldcollege.domain.User;
import edu.ldcollege.query.UserQuery;

/** 
 * @ClassName: UserService 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年10月14日 下午4:10:24 
 *  
 */
@Service("userService")
public class UserService {

	@Autowired
	private IUserDao userDao;

	@Transactional
	public long createUser(User user) {
		return userDao.save(user);
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public boolean login(UserQuery userQuery) {
		boolean result = false;
		long count = userDao.queryCount(userQuery);
		if(count > 0) {
			result = true;
		}
		return result;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public boolean verifyUserExisted(UserQuery userQuery) {
		boolean result = false;
		long count = userDao.queryCount(userQuery);
		if(count > 0) {
			result = true;
		}
		return result;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<User> querUser(UserQuery userQuery) {
		return this.userDao.queryList(userQuery);
	}

}
