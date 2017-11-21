/**   
 * @Title: IBaseService.java 
 * @Package: com.hundsun.exchange.base.common.service
 * @Description: TODO
 * @author Zhang Kui
 * @date 2017年8月24日 下午6:27:14
 * @version V1.0.0
 */
package com.denny.common.service;

import java.util.List;

/**
 * @ClassName: IBaseService
 * @Description: TODO
 * @author Zhang Kui
 * @date 2017年8月24日 下午6:27:14
 * @param <T>
 * @param <PK>
 * @param <P>
 */
public interface IBaseService<T, PK, P> {

	public Long save(T t);

	public int batchSave(List<T> tList);

	public int update(T t);

	public int deleteById(PK pk);

	public int deleteByIds(List<PK> pkList);

	public T getById(PK pk);

	public List<T> queryList(P p);

	public List<T> queryWithPage(P p);

	public Long queryCount(P p);

}
