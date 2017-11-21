/**   
 * @Title: ConnectionManager.java 
 * @Package com.denny.course.spring.aop 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月17日 上午11:56:22 
 * @version V1.0   
 */
package com.denny.course.spring.aop;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Component;

/**
 * @ClassName: ConnectionManager
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年9月17日 上午11:56:22
 * 
 */
@Component("connectionManager")
public class ConnectionManager {
	private final static Logger logger = LoggerFactory.getLogger(TransactionManager.class);
	
	@Autowired
	DataSource dataSource;

	private ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>();

	public Connection getConnection() throws SQLException {
		Connection conn = connectionHolder.get();
		if(conn == null || conn.isClosed()) {
			conn = dataSource.getConnection();
			connectionHolder.set(conn);
		}
		logger.info("当前线程(" + Thread.currentThread().getName() + ")中获取数据库连接:" + conn);
		return conn;
	}
	public void closeConnection() {
		Connection conn = connectionHolder.get();
		logger.info("当前线程(" + Thread.currentThread().getName() + ")中关闭数据库连接:" + conn);
		JdbcUtils.closeConnection(conn);
	}
	public void closeStatement(Statement stmt) {
		JdbcUtils.closeStatement(stmt);
	}
	public void closeResultSet(ResultSet rs) {
		JdbcUtils.closeResultSet(rs);
	}
	
	/**
	 * @return connectionHolder
	 */
	public ThreadLocal<Connection> getConnectionHolder() {
		return connectionHolder;
	}

	/**
	 * @param connectionHolder
	 *            the connectionHolder to set
	 */
	public void setConnectionHolder(ThreadLocal<Connection> connectionHolder) {
		this.connectionHolder = connectionHolder;
	}

	/** 
	 * @return dataSource 
	 */
	public DataSource getDataSource() {
		return dataSource;
	}

	/**
	 * @param dataSource the dataSource to set
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
