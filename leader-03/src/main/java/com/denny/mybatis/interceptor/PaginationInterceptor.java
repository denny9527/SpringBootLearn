/**   
 * @Title: PaginationInterceptor.java 
 * @Package: com.denny.mybatis.interceptor
 * @Description: TODO
 * @author Zhang Kui
 * @date 2017年8月26日 下午2:05:23
 * @version V1.0.0
 */
package com.denny.mybatis.interceptor;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.executor.ExecutorException;
import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.denny.cmomon.exception.PaginationException;
import com.denny.mybatis.enums.DatabaseType;
import com.denny.mybatis.page.param.IPageConverter;
import com.denny.mybatis.page.param.IPageParameter;
import com.denny.mybatis.page.param.PageConverterFactory;
import com.denny.mybatis.page.param.PageParameter;
import com.denny.mybatis.page.strategy.IPageStrategy;
import com.denny.mybatis.page.strategy.PageStrategyContext;
import com.denny.mybatis.page.strategy.PageStrategyFactory;
import com.denny.utils.ReflectHelper;

/**
 * 
 * @ClassName: PaginationInterceptor 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年8月29日 下午2:07:44 
 *
 */
@Intercepts({
		@org.apache.ibatis.plugin.Signature(type = org.apache.ibatis.executor.statement.StatementHandler.class, 
				method = "prepare", args = {
				Connection.class, Integer.class }) })
public class PaginationInterceptor implements Interceptor {

	private final static Logger logger = LoggerFactory.getLogger(PaginationInterceptor.class);

	private String pageMapper = "";

	private String pageVarName = "page";

	@Autowired(required = false)
	private PageConverterFactory pageConverterFactory;

	public String getPageMapper() {
		return pageMapper;
	}

	public void setPageMapper(String pageMapper) {
		this.pageMapper = pageMapper;
	}

	/**
	 * @return the pageVarName
	 */
	public String getPageVarName() {
		return pageVarName;
	}

	/**
	 * @param pageVarName
	 *            the pageVarName to set
	 */
	public void setPageVarName(String pageVarName) {
		this.pageVarName = pageVarName;
	}

	public Object intercept(Invocation invoke) throws Throwable {

		if (invoke.getTarget() instanceof RoutingStatementHandler) {
			Connection connection = (Connection) invoke.getArgs()[0];
			// 获取数据库方言
			DatabaseType databaseType = DatabaseType.fromMetaData(connection, false);
			IPageParameter page = null;
			RoutingStatementHandler statementHandler = (RoutingStatementHandler) invoke.getTarget();
			BaseStatementHandler delegate = (BaseStatementHandler) ReflectHelper.getValueByFieldName(statementHandler,
					"delegate");
			MappedStatement mappedStatement = (MappedStatement) ReflectHelper.getValueByFieldName(delegate,
					"mappedStatement");

			if (mappedStatement.getId().matches(pageMapper)) {

				BoundSql boundSql = delegate.getBoundSql();
				Object parameterObject = boundSql.getParameterObject();
				if (parameterObject == null) {
					throw new PaginationException("没有获取到SQLMAP中分页查询参数类实例");
				}

				IPageConverter pageConverter = null;
				if (parameterObject instanceof IPageParameter) {
					page = (IPageParameter) parameterObject;

				} else if (parameterObject instanceof Map) {
					Map<String, Object> map = (Map<String, Object>) parameterObject;
					page = (IPageParameter) map.get(pageVarName);
					if (page == null)
						page = new PageParameter();

				} else if (pageConverterFactory != null) {
					pageConverter = pageConverterFactory.createPageConverter(parameterObject);
					if (pageConverter != null) {
						page = pageConverter.toPage(parameterObject);
					}

				}
				if (page == null) {
					Field pageField = ReflectHelper.getFieldByFieldName(parameterObject, pageVarName);
					if (pageField != null) {
						page = (IPageParameter) ReflectHelper.getValueByFieldName(parameterObject, pageVarName);
						if (page == null)
							page = new PageParameter();

						ReflectHelper.setValueByFieldName(parameterObject, pageVarName, page);
					} else {
						throw new PaginationException("没有分页参数类实例");
					}
				}

				String sql = boundSql.getSql();
				if (page.isRequireTotal()) {
					// 查询总数的Sql: select count(0) from (" + sql + ") myCount ;
					String countSql = generateCountSql(sql);
					logger.debug("查询总数的 SQL:[{}]", countSql);
					PreparedStatement countStmt = connection.prepareStatement(countSql);
					try {
						setParameters(countStmt, mappedStatement, boundSql, parameterObject);
						ResultSet rs = countStmt.executeQuery();// 获取查询结果总数
						int count = 0;
						if (rs.next()) {
							count = rs.getInt(1);
						}
						page.setTotal(count);
						if (pageConverter != null) {
							pageConverter.returnTotal(page, parameterObject, count);// 在定制化查询类中设置查询记录总数
						}
						rs.close();
					} finally {
						countStmt.close();
					}
				}
				if (databaseType == null) {
					throw new PaginationException("不能获取数据方言,请检查mybatis相关配置!");
				}
				// 根据数据方言获取分页策略构建分页查询SQL语句
				IPageStrategy pageStrategy = PageStrategyFactory.getPageStrategy(databaseType);
				PageStrategyContext pageStrategyContext = new PageStrategyContext(pageStrategy, page);
				String pageSql = pageStrategyContext.buildPagingSql(sql);
				logger.debug("生成的分页语句:[{}]", pageSql);
				ReflectHelper.setValueByFieldName(boundSql, "sql", pageSql);
			}
		}
		return invoke.proceed();
	}

	/**
	 * 使用查询类(分页)实例设置SQLMAP中查询语句中的所有条件参数 @Title: setParameters @Description:
	 * TODO @param @param ps @param @param mappedStatement @param @param
	 * boundSql @param @param parameterObject @param @throws SQLException @return
	 * void @throws
	 */
	private void setParameters(PreparedStatement ps, MappedStatement mappedStatement, BoundSql boundSql,
			Object parameterObject) throws SQLException {
		ErrorContext.instance().activity("setting parameters").object(mappedStatement.getParameterMap().getId());
		List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
		if (parameterMappings != null) {
			Configuration configuration = mappedStatement.getConfiguration();
			TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
			MetaObject metaObject = parameterObject == null ? null : configuration.newMetaObject(parameterObject);
			for (int i = 0; i < parameterMappings.size(); i++) {
				ParameterMapping parameterMapping = parameterMappings.get(i);
				if (parameterMapping.getMode() != ParameterMode.OUT) {
					Object value;
					String propertyName = parameterMapping.getProperty();
					PropertyTokenizer prop = new PropertyTokenizer(propertyName);
					if (parameterObject == null) {
						value = null;
					} else if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
						value = parameterObject;
					} else if (boundSql.hasAdditionalParameter(propertyName)) {
						value = boundSql.getAdditionalParameter(propertyName);
					} else if (propertyName.startsWith(ForEachSqlNode.ITEM_PREFIX)
							&& boundSql.hasAdditionalParameter(prop.getName())) {
						value = boundSql.getAdditionalParameter(prop.getName());
						if (value != null) {
							value = configuration.newMetaObject(value)
									.getValue(propertyName.substring(prop.getName().length()));
						}
					} else {
						value = metaObject == null ? null : metaObject.getValue(propertyName);
					}
					TypeHandler typeHandler = parameterMapping.getTypeHandler();
					if (typeHandler == null) {
						throw new ExecutorException("没有找到SQL语句:[" + mappedStatement.getId() + "]中的参数:" + propertyName
								+ "的类型处理器(TypeHandler)");
					}
					typeHandler.setParameter(ps, i + 1, value, parameterMapping.getJdbcType());
				}
			}
		}
	}

	/**
	 * 构建查询记录总数SQL语句 @Title: generateCountSql @Description: TODO @param @param
	 * sql @param @return @return String @throws
	 */
	private String generateCountSql(String sql) {
		String upperSql = sql.trim().toUpperCase();
		int startIndex = 0;
		int stack = 1;
		for (int i = 0; i < 10; i++) {
			int indexs = upperSql.indexOf("SELECT ", startIndex + 2);
			int indexf = upperSql.indexOf("FROM ", startIndex + 2);
			if (indexs < 0 || indexf < indexs) {
				stack--;
				startIndex = indexf;
			} else {
				stack++;
				startIndex = indexs;
			}
			if (stack == 0) {
				return "select count(1)  " + sql.substring(indexf);
			}
		}
		return "select count(1) from (" + sql + ") myCount";
	}

	public void setProperties(Properties p) {

	}

	/*
	 * (non-Javadoc) <p>Title: plugin</p> <p>Description: </p>
	 * 
	 * @param target
	 * 
	 * @return
	 * 
	 * @see org.apache.ibatis.plugin.Interceptor#plugin(java.lang.Object)
	 */
	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

}
