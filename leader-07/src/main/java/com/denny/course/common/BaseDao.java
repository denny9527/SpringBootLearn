/**   
 * @Title: BaseDao.java 
 * @Package com.denny.ioc.common.dao 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月3日 下午9:27:13 
 * @version V1.0   
 */
package com.denny.course.common;

import java.util.List;

/**
 * @ClassName: BaseDao
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年9月3日 下午9:27:13
 * 
 */
public interface BaseDao<T> {

	public abstract int save(T t);

	public abstract int delete(Long id);

	public abstract int update(T t);

	public abstract List<T> queryList(T t);
}
