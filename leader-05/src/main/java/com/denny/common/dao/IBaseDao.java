/**   
 * @Title: IBaseDao.java 
 * @Package: com.denny.cmomon.dao
 * @Description: 基本泛型DAO
 * @author Zhang Kui 
 * @date 2017年8月24日 下午6:27:14
 * @version V1.0.0
 */
package com.denny.common.dao;

import java.util.List;

/**
 * 
 * @ClassName: IBaseDao 
 * @Description: TODO 
 * @author Zhang Kui 
 * @date 2017年8月24日 下午6:27:14
 * @param <T>
 * @param <PK>
 * @param <P>
 */
public interface IBaseDao<T, PK, P> {

	public int save(T t);

	public int batchSave(List<T> tList);

	public int update(T t);

	public int deleteById(PK pk);
	
	public int deleteByIds(List<PK> pkList);
	
	public T getById(PK pk);
	
	public List<T> queryList(P p);
	
	public Long queryCount(P p);

}
