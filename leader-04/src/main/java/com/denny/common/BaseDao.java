/**   
 * @Title: BaseDao.java 
 * @Package com.denny.ioc.common.dao 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月3日 下午9:27:13 
 * @version V1.0   
 */
package com.denny.common;

import java.util.List;

import com.denny.common.user.User;

/**
 * @ClassName: BaseDao
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年9月3日 下午9:27:13
 * 
 */
public abstract class BaseDao<T> {

	public abstract int save(T t);

	public abstract int delete(Long id);

	public abstract int update(T t);

	public abstract List<T> queryList(T t);

}
