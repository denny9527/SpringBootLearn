/**   
 * @Title: PagingStrategy.java 
 * @Package com.denny.mybatis.page.strategy 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年8月24日 下午2:02:08 
 * @version V1.0   
 */
package com.denny.mybatis.page.strategy;

import com.denny.mybatis.enums.DatabaseType;

/** 
 * @ClassName: PagingStrategy 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com  
 * @date 2017年8月24日 下午2:02:08 
 *  
 */
public interface IPageStrategy {

	 /**
	  * 获取数据类型
	  * @Title: getDatabaseId 
	  * @Description: TODO 
	  * @param @return
	  * @return String
	  * @throws
	  */
	  public abstract DatabaseType getDatabaseType();
	  
	  /**
	   * @Title: generatePageSql 
	   * @Description: 生成分页SQL语句
	   * @param @param querySql
	   * @param @param start
	   * @param @param limit
	   * @param @return
	   * @return String
	   * @throws
	   */
	  public abstract String generatePageSql(String querySql, int start, int limit);
	  
}
