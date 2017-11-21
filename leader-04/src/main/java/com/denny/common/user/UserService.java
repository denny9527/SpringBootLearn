/**   
 * @Title: UserService.java 
 * @Package com.denny.common.user 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月3日 下午9:44:32 
 * @version V1.0   
 */
package com.denny.common.user;

import com.denny.common.BaseService;
import com.denny.ioc.annotation.Bean;

/** 
 * @ClassName: UserService 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月3日 下午9:44:32 
 *  
 */
@Bean("userService")
public class UserService extends BaseService<User> {
}
