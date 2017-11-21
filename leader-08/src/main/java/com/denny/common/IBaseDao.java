/**   
 * @Title: BaseDao.java 
 * @Package com.denny.ioc.common.dao 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年10月5日 下午9:27:13 
 * @version V1.0   
 */
package com.denny.common;

import java.util.List;

/**
 * @ClassName: BaseDao
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年10月5日 下午9:27:13
 * 
 */
public interface IBaseDao<T> {

	public abstract int deleteByPrimaryKey(Long id);

	public abstract int insert(T t);

	public abstract T selectByPrimaryKey(Long id);

	public abstract List<T> selectAll();
	
	public abstract int updateByPrimaryKey(T t);
}
