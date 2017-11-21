/**
 * @Title: IUserDao.java
 * @Package: edu.ldcollege.dao
 * @Description: 
 * @author Zhang Kui
 * @date 2017年10月14日 下午03:47:49
 * @version V1.0.0
 */
package edu.ldcollege.dao;

import com.denny.common.dao.IBaseDao;
import edu.ldcollege.domain.User;
import edu.ldcollege.query.UserQuery;

/**
 * @ClassName: IUserDao
 * @Description: 
 * @author Zhang Kui
 * @date 2017年10月14日 下午03:47:49
 * @version 1.0.0 
 */
public interface IUserDao extends IBaseDao<User, Long, UserQuery> {
}