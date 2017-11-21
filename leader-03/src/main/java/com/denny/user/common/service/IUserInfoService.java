/**
 * @Title: IUserInfoService.java
 * @Package: com.denny.user.common.service
 * @Description: 
 * @author Zhang Kui
 * @date 2017年08月26日 下午09:34:57
 * @version V1.0.0
 */
package com.denny.user.common.service;

import com.denny.common.service.IBaseService;
import com.denny.user.common.bean.UserInfo;
import com.denny.user.common.query.UserInfoQuery;

/**
 * @ClassName: IUserInfoService
 * @Description: 
 * @author Zhang Kui
 * @date 2017年08月26日 下午09:34:57
 * @version 1.0.0 
 */
public interface IUserInfoService extends IBaseService<UserInfo, Long, UserInfoQuery> {
}