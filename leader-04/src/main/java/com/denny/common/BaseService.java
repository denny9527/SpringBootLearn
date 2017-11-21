/**   
 * @Title: BaseService.java 
 * @Package com.denny.ioc.common.dao 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月3日 下午9:32:20 
 * @version V1.0   
 */
package com.denny.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.denny.common.user.User;
import com.denny.ioc.annotation.Injection;

/** 
 * @ClassName: BaseService 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月3日 下午9:32:20 
 *  
 */
public abstract class BaseService<T> {

	@Injection
	private BaseDao<T> baseDao;
	
	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */
	public BaseService() {
		// TODO Auto-generated constructor stub
	}
	
	public int save(T t) {
		this.baseDao.save(t);
		throw new RuntimeException("抛出异常验证事务回滚!");
	}
	
	public int delete(Long id) {
		return this.baseDao.delete(id);
	}
	
	public int update(T t) {
		return this.baseDao.update(t);
	}
	
	public List<T> queryList(T t){
		return this.baseDao.queryList(t);
	}

	/** 
	 * @return baseDao 
	 */
	public BaseDao<T> getBaseDao() {
		return baseDao;
	}

	/**
	 * @param baseDao the baseDao to set
	 */
	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

}
