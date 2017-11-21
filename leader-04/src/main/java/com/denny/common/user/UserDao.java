/**   
 * @Title: UserDao.java 
 * @Package com.denny.common.user 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月3日 下午9:43:12 
 * @version V1.0   
 */
package com.denny.common.user;

import java.util.List;

import com.denny.common.BaseDao;
import com.denny.ioc.annotation.Bean;

/** 
 * @ClassName: UserDao 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月3日 下午9:43:12 
 *  
 */
@Bean("userDao")
public class UserDao extends BaseDao<User>{

	/* (non-Javadoc) 
	 * <p>Title: save</p> 
	 * <p>Description: </p> 
	 * @param t
	 * @return 
	 * @see com.denny.common.BaseDao#save(java.lang.Object) 
	 */
	@Override
	public int save(User t) {
		return 0;
	}

	/* (non-Javadoc) 
	 * <p>Title: delete</p> 
	 * <p>Description: </p> 
	 * @param id
	 * @return 
	 * @see com.denny.common.BaseDao#delete(java.lang.Long) 
	 */
	@Override
	public int delete(Long id) {
		return 0;
	}

	/* (non-Javadoc) 
	 * <p>Title: update</p> 
	 * <p>Description: </p> 
	 * @param t
	 * @return 
	 * @see com.denny.common.BaseDao#update(java.lang.Object) 
	 */
	@Override
	public int update(User t) {
		return 0;
	}

	/* (non-Javadoc) 
	 * <p>Title: queryList</p> 
	 * <p>Description: </p> 
	 * @param t
	 * @return 
	 * @see com.denny.common.BaseDao#queryList(java.lang.Object) 
	 */
	@Override
	public List<User> queryList(User t) {
		return null;
	}

}
