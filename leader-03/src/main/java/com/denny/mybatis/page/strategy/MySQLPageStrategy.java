/**   
 * @Title: MySQLPageStrategy.java 
 * @Package com.denny.mybatis.page.strategy 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年8月24日 下午2:05:25 
 * @version V1.0   
 */
package com.denny.mybatis.page.strategy;

import org.springframework.stereotype.Component;

import com.denny.mybatis.enums.DatabaseType;

/** 
 * @ClassName: MySQLPageStrategy 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年8月24日 下午2:05:25 
 *  
 */
@Component("mySQLPageStrategy")
public class MySQLPageStrategy implements IPageStrategy {

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */
	public MySQLPageStrategy() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc) 
	 * <p>Title: getDatabaseType</p> 
	 * <p>Description: </p> 
	 * @return 
	 * @see com.denny.mybatis.page.strategy.IPageStrategy#getDatabaseType() 
	 */
	@Override
	public DatabaseType getDatabaseType() {
		return DatabaseType.MYSQL;
	}
	/* (non-Javadoc) 
	 * <p>Title: generatePageSql</p> 
	 * <p>Description: </p> 
	 * @param querySql
	 * @param start
	 * @param limit
	 * @return 
	 * @see com.denny.mybatis.page.strategy.PagingStrategy#generatePageSql(java.lang.String, int, int) 
	 */
	@Override
	public String generatePageSql(String querySql, int start, int limit) {
	    String pageSql = querySql + " limit " + start + "," + limit;
	    return pageSql;
	}

}
