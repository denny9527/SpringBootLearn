/**   
 * @Title: BaseService.java 
 * @Package com.denny.ioc.common.dao 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年10月5日 下午9:32:20 
 * @version V1.0   
 */
package com.denny.common;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.denny.task01.common.domain.User;

/** 
 * @ClassName: BaseService 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年10月5日 下午9:32:20 
 *  
 */
public abstract class BaseService<T> implements IBaseService<T> {
	
	private final static Logger logger = LoggerFactory.getLogger(BaseService.class);
	
	@Autowired
	private IBaseDao<T> baseDao;
	
	public int deleteById(Long id) {
		int result;
		logger.info(this.getClass().getName()+"执行根据ID删除数据操作开始");
		result = this.baseDao.deleteByPrimaryKey(id);
		logger.info(this.getClass().getName()+"执行根据ID删除数据操作开始");
		return result;
	}
	
	public int save(T t) {
		logger.info(this.getClass().getName()+"执行保存数据操作");
		return this.baseDao.insert(t);
	}
	
	public T getById(Long id) {
		logger.info(this.getClass().getName()+"执行根据ID查询数据操作");
		return this.baseDao.selectByPrimaryKey(id);
	}
	
	public List<T> queryAll(){
		logger.info(this.getClass().getName()+"执行查询所有数据操作");
		return this.baseDao.selectAll();
	}
	
	public int update(T t){
		logger.info(this.getClass().getName()+"执行根据ID及其他字段更新数据操作");
		return this.baseDao.updateByPrimaryKey(t);
	}

	/** 
	 * @return baseDao 
	 */
	public IBaseDao<T> getBaseDao() {
		return baseDao;
	}

	/**
	 * @param baseDao the baseDao to set
	 */
	public void setBaseDao(IBaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

}
