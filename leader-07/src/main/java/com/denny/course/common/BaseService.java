/**   
 * @Title: BaseService.java 
 * @Package com.denny.ioc.common.dao 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月3日 下午9:32:20 
 * @version V1.0   
 */
package com.denny.course.common;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.denny.common.utils.ThreadLocalUtil;

/** 
 * @ClassName: BaseService 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月3日 下午9:32:20 
 *  
 */
//@Transactional(noRollbackFor= {RuntimeException.class})
public abstract class BaseService<T> implements IBaseService<T> {
	
	private final static Logger logger = LoggerFactory.getLogger(BaseService.class);
	
	@Autowired
	private BaseDao<T> baseDao;
	
	public int save(T t) /*throws Exception*/ {
		ThreadLocalUtil.dumphreadLocals();
		int result;
		logger.info(this.getClass().getName()+"执行保存数据操作开始");
		result = this.baseDao.save(t);
		logger.info(this.getClass().getName()+"执行保存数据操作结束");
		return result;
	}
	
	public int delete(Long id) {
		ThreadLocalUtil.dumphreadLocals();
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
