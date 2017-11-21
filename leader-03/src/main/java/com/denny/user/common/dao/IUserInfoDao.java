/**
 * @Title: IUserInfoDao.java
 * @Package: com.denny.user.common.dao
 * @Description: 
 * @author Zhang Kui
 * @date 2017年08月26日 下午09:34:57
 * @version V1.0.0
 */
package com.denny.user.common.dao;

import com.denny.common.dao.IBaseDao;
import com.denny.user.common.bean.UserInfo;
import com.denny.user.common.query.UserInfoQuery;

/**
 * @ClassName: IUserInfoDao
 * @Description: 
 * @author Zhang Kui
 * @date 2017年08月26日 下午09:34:57
 * @version 1.0.0 
 */
public interface IUserInfoDao extends IBaseDao<UserInfo, Long, UserInfoQuery> {
}