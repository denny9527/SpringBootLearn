/**   
 * @Title: PageParameter.java 
 * @Package com.denny.mybatis.page.param 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年8月24日 下午2:20:06 
 * @version V1.0   
 */
package com.denny.mybatis.page.param;

/** 
 * @ClassName: PageParameter 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年8月24日 下午2:20:06 
 *  
 */
public interface IPageParameter {
	
	  public abstract int getStart();

	  public abstract int getLimit();

	  public abstract boolean isRequireTotal();

	  public abstract void setTotal(int paramInt);
}
