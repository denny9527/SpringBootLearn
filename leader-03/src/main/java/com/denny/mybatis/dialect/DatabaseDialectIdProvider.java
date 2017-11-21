/**   
 * @Title: DatabaseIdProvider.java 
 * @Package com.denny.mybatis.page.strategy 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年8月24日 下午2:28:11 
 * @version V1.0   
 */
package com.denny.mybatis.dialect;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: DatabaseIdProvider
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年8月24日 下午2:28:11
 * 
 */
public class DatabaseDialectIdProvider extends VendorDatabaseIdProvider {
	
	private static final Logger logger = LoggerFactory.getLogger(DatabaseDialectIdProvider.class);

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	public DatabaseDialectIdProvider() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc) 
	 * <p>Title: getDatabaseId</p> 
	 * <p>Description: </p> 
	 * @param dataSource
	 * @return 
	 * @see org.apache.ibatis.mapping.VendorDatabaseIdProvider#getDatabaseId(javax.sql.DataSource) 
	 */
	@Override
	public String getDatabaseId(DataSource dataSource) {
		// TODO Auto-generated method stub
		return super.getDatabaseId(dataSource);
	}

	/* (non-Javadoc) 
	 * <p>Title: setProperties</p> 
	 * <p>Description: </p> 
	 * @param p 
	 * @see org.apache.ibatis.mapping.VendorDatabaseIdProvider#setProperties(java.util.Properties) 
	 */
	@Override
	public void setProperties(Properties p) {
		// TODO Auto-generated method stub
		super.setProperties(p);
	}

}
