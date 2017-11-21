/**   
 * @Title: PageStrategyType.java 
 * @Package com.denny.mybatis.enums 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年8月25日 上午9:55:00 
 * @version V1.0   
 */
package com.denny.mybatis.enums;

import java.util.HashMap;
import java.util.Map;

import com.denny.mybatis.enums.DatabaseType;
import com.denny.mybatis.page.strategy.MySQLPageStrategy;
import com.denny.mybatis.page.strategy.OraclePageStrategy;


/**
 * @ClassName: PageStrategyType
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年8月25日 上午9:55:00
 * 
 */
public enum PageStrategyType {

	MYSQL_PAGE_STRATEGY("MySQL", MySQLPageStrategy.class), ORACLE_PAGE_STRATEGY("Oracle",OraclePageStrategy.class);

	private String databaseProductName;
	private Class strategyClass;

	private final static Map<DatabaseType, Class> pageStrategyMap;

	static {
		pageStrategyMap = new HashMap<DatabaseType, Class>();
		for (PageStrategyType pageStrategy : PageStrategyType.values()) {
			pageStrategyMap.put(DatabaseType.fromProductName(pageStrategy.getDatabaseProductName()),
					pageStrategy.getStrategyClass());
		}
	}

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param databaseProductName
	 * @param strategyClass
	 */
	private PageStrategyType(String databaseProductName, Class strategyClass) {
		this.databaseProductName = databaseProductName;
		this.strategyClass = strategyClass;
	}

	/**
	 * @return databaseProductName
	 */
	public String getDatabaseProductName() {
		return databaseProductName;
	}

	/**
	 * @param databaseProductName
	 *            the databaseProductName to set
	 */
	public void setDatabaseProductName(String databaseProductName) {
		this.databaseProductName = databaseProductName;
	}

	/**
	 * @return strategyClass
	 */
	public Class getStrategyClass() {
		return strategyClass;
	}

	/**
	 * @param strategyClass
	 *            the strategyClass to set
	 */
	public void setStrategyClass(Class strategyClass) {
		this.strategyClass = strategyClass;
	}
	
	public static Map<DatabaseType, Class> getPageStrategyMap() {
		return pageStrategyMap;
	}

}
