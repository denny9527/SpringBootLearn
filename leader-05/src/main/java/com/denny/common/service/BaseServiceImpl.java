/**   
 * @Title: BaseServiceImpl.java 
 * @Package: com.hundsun.exchange.base.common.service
 * @Description: TODO
 * @author Zhang Kui
 * @date 2017年8月26日 下午2:05:23 
 * @version V1.0.0
 */
package com.denny.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.denny.common.dao.IBaseDao;

/**
 * 
 * @ClassName: BaseServiceImpl 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年8月26日 下午2:05:23
 * 
 * @param <T>
 * @param <PK>
 * @param <P>
 */
public abstract class BaseServiceImpl<T, PK, P> implements IBaseService<T, PK, P> {

	@Autowired
	private IBaseDao<T, PK, P> baseDao;

	public IBaseDao<T, PK, P> getBaseDao(){
		return this.baseDao;
	}

	@Override
	public final int save(T t) {
		return getBaseDao().save(t);
	}

	@Override
	public final int batchSave(List<T> tList) {
		return getBaseDao().batchSave(tList);
	}

	@Override
	@Transactional
	public final int update(T t) {
		return getBaseDao().update(t);
	}

	@Override
	@Transactional
	public final int deleteById(PK pk) {
		return getBaseDao().deleteById(pk);
	}

	@Override
	public final int deleteByIds(List<PK> pkList) {
		return getBaseDao().deleteByIds(pkList);
	}

	@Override
	public final T getById(PK pk) {
		return getBaseDao().getById(pk);
	}

	@Override
	public final List<T> queryList(P p) {
		return getBaseDao().queryList(p);
	}

	@Override
	public final Long queryCount(P p) {
		return getBaseDao().queryCount(p);
	}
	
}
