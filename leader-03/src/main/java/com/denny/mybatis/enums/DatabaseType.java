/**   
 * @Title: DatabaseType.java 
 * @Package com.denny.mybatis.enums 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年8月25日 上午9:05:26 
 * @version V1.0   
 */
package com.denny.mybatis.enums;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

/** 
 * @ClassName: DatabaseType 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年8月25日 上午9:05:26 
 *  
 */
public enum DatabaseType {

	MYSQL("MySQL"),
	ORACLE("Oracle");
	
	private static final Map<String, DatabaseType> nameMap;
	
	private String productName;
	
	static {
		nameMap = new HashMap<String, DatabaseType>();
		for(DatabaseType type: values()){
			nameMap.put(type.getProductName(), type);
		}
	}
	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p> 
	 * @param productName 
	 */
	private DatabaseType(String productName) {
		this.productName = productName;
	}

	/** 
	 * @return productName 
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public static DatabaseType fromProductName(String productName){
		if(!nameMap.containsKey(productName)){
			throw new IllegalArgumentException("数据库类型没有找到,来自 productName: [" + 
					productName + "]");
		}
		else{
			return nameMap.get(productName);
		}
	}
	
	public static DatabaseType fromMetaData(DataSource dataSource, boolean isClose) throws SQLException {
	    Connection con = null;
	    try {
	      con = dataSource.getConnection();
	      DatabaseMetaData metaData = con.getMetaData();
	      return fromProductName(metaData.getDatabaseProductName());
	    } finally {
	      if (con != null && isClose) {
	        try {
	          con.close();
	        } catch (SQLException e) {
	          // ignored
	        }
	      }
	    }
	}
	
	public static DatabaseType fromMetaData(Connection connection, boolean isClose) throws SQLException {
	    try {
	      DatabaseMetaData metaData = connection.getMetaData();
	      return fromProductName(metaData.getDatabaseProductName());
	    } finally {
	      if (connection != null && isClose) {
	        try {
	        	connection.close();
	        } catch (SQLException e) {
	          // ignored
	        }
	      }
	    }
	}
}
