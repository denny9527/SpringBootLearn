/**   
 * @Title: CustomJdbcTemplate.java 
 * @Package com.denny.spring.aop 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月17日 上午10:17:32 
 * @version V1.0   
 */
package com.denny.course.spring.aop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ArgumentPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.jdbc.support.SQLExceptionTranslator;
import org.springframework.stereotype.Component;

import com.denny.course.domain.User;

import sun.misc.Contended;

/** 
 * @ClassName: CustomJdbcTemplate 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月17日 上午10:17:32 
 *  
 */
@Component("jdbcTemplate")
public class CustomJdbcTemplate {
	
	private final static Logger logger = LoggerFactory.getLogger(CustomJdbcTemplate.class);
	
	@Autowired
	private ConnectionManager connectionManager;
	
	private SQLExceptionTranslator exceptionTranslator;

	public CustomJdbcTemplate(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
		exceptionTranslator = new SQLErrorCodeSQLExceptionTranslator(connectionManager.getDataSource());
	}
	public int update(String sql, Object... args) throws DataAccessException {
		PreparedStatement stmt = null;
		Connection conn = null;
		try {
			conn = this.connectionManager.getConnection();
			stmt = conn.prepareStatement(sql);
			ArgumentPreparedStatementSetter stmtSetter = new ArgumentPreparedStatementSetter(args);
			stmtSetter.setValues(stmt);
			logger.info("执行SQL语句:"+stmt.toString());
			return stmt.executeUpdate();
		} catch (SQLException ex) {
			connectionManager.closeStatement(stmt);
			stmt = null;
			conn = null;
			throw exceptionTranslator.translate("PreparedStatement execute update", sql, ex);
		}finally {
			connectionManager.closeStatement(stmt);
		}
	}

	
	public <T> List<T> query(String sql, Object[] args, RowMapper<T> rowMapper) {
		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = this.connectionManager.getConnection();
			RowMapperResultSetExtractor resultSetExtractor = new RowMapperResultSetExtractor<T>(rowMapper);
			ArgumentPreparedStatementSetter stmtSetter = new ArgumentPreparedStatementSetter(args);
			stmt = conn.prepareStatement(sql);
			stmtSetter.setValues(stmt);
			rs = stmt.executeQuery();
			logger.info("执行SQL语句:"+stmt.toString());
			return resultSetExtractor.extractData(rs);
		} catch (SQLException ex) {
			connectionManager.closeResultSet(rs);
			rs = null;
			connectionManager.closeStatement(stmt);
			stmt = null;
			conn = null;
			throw exceptionTranslator.translate("PreparedStatement execute update", sql, ex);
		}finally {
			connectionManager.closeResultSet(rs);
			connectionManager.closeStatement(stmt);
		}
	}
	
}
