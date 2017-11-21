/**   
 * @Title: IBaseSerive.java 
 * @Package com.denny.common 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月15日 下午4:05:57 
 * @version V1.0   
 */
package com.denny.common;

import java.util.List;

/** 
 * @ClassName: IBaseSerive 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月15日 下午4:05:57 
 *  
 */
public interface IBaseService<T> {

	public abstract int save(T t);
	
	public abstract int delete(Long id);
	
	public abstract int update(T t);
	
	public abstract List<T> queryList(T t);
	
}
