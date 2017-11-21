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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.denny.common.user.User;
import com.denny.spring.aop.ServiceAspect;

/** 
 * @ClassName: BaseService 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月3日 下午9:32:20 
 *  
 */
public abstract class BaseService<T> implements IBaseService<T> {
	
	private final static Logger logger = LoggerFactory.getLogger(BaseService.class);
	
	@Autowired
	private BaseDao<T> baseDao;
	
	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */
	public BaseService() {
		// TODO Auto-generated constructor stub
	}
	
	public int save(T t) {
//		try {
//			logger.info(this.getClass().getName()+"执行保存操作");
//			throw new RuntimeException("保存操作失败!");
//		} catch (Exception e) {
//			throw new RuntimeException("保存操作失败!", e);
//		}
		return this.baseDao.save(t);
	}
	
	public int delete(Long id) {
		logger.info(this.getClass().getName()+"执行根据ID删除数据操作");
		return this.baseDao.delete(id);
	}
	
	public int update(T t) {
		logger.info(this.getClass().getName()+"执行更新数据操作");
		return this.baseDao.update(t);
	}
	
	public List<T> queryList(T t){
		logger.info(this.getClass().getName()+"执行查询数据操作");
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
