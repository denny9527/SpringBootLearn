/**
 * @Title: UserInfoServiceImpl.java
 * @Package: com.denny.user.common.service.impl
 * @Description: 
 * @author Zhang Kui
 * @date 2017年08月26日 下午09:34:57
 * @version V1.0.0
 */
package com.denny.user.common.service;

import com.denny.common.dao.IBaseDao;
import com.denny.common.service.BaseServiceImpl;
import com.denny.user.common.bean.UserInfo;
import com.denny.user.common.dao.IUserInfoDao;
import com.denny.user.common.query.UserInfoQuery;
import com.denny.user.common.service.IUserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: UserInfoServiceImpl
 * @Description: 
 * @author Zhang Kui
 * @date 2017年08月26日 下午09:34:57
 * @version 1.0.0
 */
@Service("userInfoService")
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfo, Long, UserInfoQuery> implements IUserInfoService {

    private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Autowired
    private IUserInfoDao userInfoDao;

    public IBaseDao<UserInfo, Long, UserInfoQuery> getBaseDao() {
        return this.userInfoDao;
    }
    
}