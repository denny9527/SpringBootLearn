/**   
 * @Title: IPageConverter.java 
 * @Package com.denny.mybatis.page.param 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年8月24日 下午2:19:29 
 * @version V1.0   
 */
package com.denny.mybatis.page.param;

/**
 * @ClassName: IPageConverter
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年8月24日 下午2:19:29
 * 
 */
public interface IPageConverter<T> {
	
	public abstract IPageParameter toPage(T paramT);

	public abstract void returnTotal(IPageParameter pageParameter, T paramT, int paramInt);
}
