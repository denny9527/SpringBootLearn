/**   
 * @Title: OraclePageStrategy.java 
 * @Package com.denny.mybatis.page.strategy 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年8月24日 下午2:06:18 
 * @version V1.0   
 */
package com.denny.mybatis.page.strategy;

import org.springframework.stereotype.Component;

import com.denny.mybatis.enums.DatabaseType;

/**
 * @ClassName: OraclePageStrategy
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年8月24日 下午2:06:18
 * 
 */
@Component("oraclePageStrategy")
public class OraclePageStrategy implements IPageStrategy {

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	public OraclePageStrategy() {
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
		return DatabaseType.ORACLE;
	}



	/*
	 * (non-Javadoc) <p>Title: generatePageSql</p> <p>Description: </p>
	 * 
	 * @param querySql
	 * 
	 * @param start
	 * 
	 * @param limit
	 * 
	 * @return
	 * 
	 * @see
	 * com.denny.mybatis.page.strategy.PagingStrategy#generatePageSql(java.lang.
	 * String, int, int)
	 */
	@Override
	public String generatePageSql(String querySql, int start, int limit) {
		StringBuffer pageSql = new StringBuffer();
		pageSql.append("select * from (select tmp_tb.*,ROWNUM row_id from (");
		pageSql.append(querySql);
		pageSql.append(")  tmp_tb where ROWNUM<=");
		pageSql.append(start + limit);
		pageSql.append(") where row_id>");
		pageSql.append(start);

		return pageSql.toString();
	}

}
