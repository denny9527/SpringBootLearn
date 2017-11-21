/**   
 * @Title: TransactionManager.java 
 * @Package com.denny.course.spring.aop 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月17日 上午9:31:11 
 * @version V1.0   
 */
package com.denny.course.spring.aop;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.denny.spring.aop.ServiceAspect;

/**
 * @ClassName: TransactionManager
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年9月17日 上午9:31:11
 * 
 */
@Component("transactionManager")
public class TransactionManager {
	private final static Logger logger = LoggerFactory.getLogger(TransactionManager.class);

	@Autowired
	private ConnectionManager connectionManager;
	public void beginTransaction() throws SQLException {
		Connection conn = connectionManager.getConnection();
		logger.info("当前线程(" + Thread.currentThread().getName() + ")中数据库连接事务开启:" + conn);
		if (conn.getAutoCommit()) conn.setAutoCommit(false);
	}

	public void commitTransaction() throws SQLException {
		Connection conn = connectionManager.getConnection();
		logger.info("当前线程(" + Thread.currentThread().getName() + ")中数据库连接事务提交:" + conn);
		if (!conn.getAutoCommit()) conn.commit();

	}

	public void rollbackTransaction() throws SQLException {
		Connection conn = connectionManager.getConnection();
		logger.info("当前线程(" + Thread.currentThread().getName() + ")中数据库连接事务回滚:" + conn);
		if (!conn.getAutoCommit()) conn.rollback();
	}

}
