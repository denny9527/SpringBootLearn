/**   
 * @Title: CustomJdbcTemplate.java 
 * @Package com.denny.spring.aop 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年10月5日 上午10:17:32 
 * @version V1.0   
 */
package com.denny.task01.common.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ArgumentPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.jdbc.support.SQLExceptionTranslator;
import org.springframework.stereotype.Component;

/** 
 * @ClassName: CustomJdbcTemplate 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年10月5日 上午10:17:32 
 *  
 */
@Component("jdbcTemplate")
public class CustomJdbcTemplate {
	private final static Logger logger = LoggerFactory.getLogger(CustomJdbcTemplate.class);
	
	@Autowired
	DataSource dataSource;
	
	private SQLExceptionTranslator exceptionTranslator;

	public int update(String sql, Object... args) throws DataAccessException {
		PreparedStatement stmt = null;
		Connection conn = null;
		try {
			conn = DataSourceUtils.doGetConnection(dataSource);
			stmt = conn.prepareStatement(sql);
			ArgumentPreparedStatementSetter stmtSetter = new ArgumentPreparedStatementSetter(args);
			stmtSetter.setValues(stmt);
			logger.info("原生JDBC执行SQL语句:"+stmt.toString());
			return stmt.executeUpdate();
		} catch (SQLException ex) {
			JdbcUtils.closeStatement(stmt);
			stmt = null;
			conn = null;
			throw exceptionTranslator.translate("PreparedStatement execute update", sql, ex);
		}finally {
			JdbcUtils.closeStatement(stmt);
		}
	}

	public <T> List<T> query(String sql, Object[] args, RowMapper<T> rowMapper) {
		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DataSourceUtils.doGetConnection(dataSource);
			RowMapperResultSetExtractor resultSetExtractor = new RowMapperResultSetExtractor<T>(rowMapper);
			ArgumentPreparedStatementSetter stmtSetter = new ArgumentPreparedStatementSetter(args);
			stmt = conn.prepareStatement(sql);
			stmtSetter.setValues(stmt);
			rs = stmt.executeQuery();
			logger.info("执行SQL语句:"+stmt.toString());
			return resultSetExtractor.extractData(rs);
		} catch (SQLException ex) {
			JdbcUtils.closeResultSet(rs);
			rs = null;
			JdbcUtils.closeStatement(stmt);
			stmt = null;
			conn = null;
			throw exceptionTranslator.translate("PreparedStatement execute update", sql, ex);
		}finally {
			JdbcUtils.closeStatement(stmt);
			JdbcUtils.closeResultSet(rs);
		}
	}
}

