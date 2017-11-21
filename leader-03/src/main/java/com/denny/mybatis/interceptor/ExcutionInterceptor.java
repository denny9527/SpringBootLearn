/**   
 * @Title: ExcutionInterceptor.java 
 * @Package com.denny.mybatis.interceptor 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年8月25日 上午11:16:17 
 * @version V1.0   
 */
package com.denny.mybatis.interceptor;

import java.util.Properties;

import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import com.denny.utils.ReflectHelper;

/**
 * @ClassName: ExcutionInterceptor
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年8月25日 上午11:16:17
 * 
 */
@Intercepts({
		@org.apache.ibatis.plugin.Signature(type = StatementHandler.class, method = "batch", args = {
				java.sql.Statement.class }),
		@org.apache.ibatis.plugin.Signature(type = StatementHandler.class, method = "update", args = {
				java.sql.Statement.class }),
		@org.apache.ibatis.plugin.Signature(type = StatementHandler.class, method = "query", args = {
				java.sql.Statement.class, org.apache.ibatis.session.ResultHandler.class }) })
public class ExcutionInterceptor implements Interceptor {

	private static final Logger logger = LoggerFactory.getLogger(ExcutionInterceptor.class);

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	public ExcutionInterceptor() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc) <p>Title: intercept</p> <p>Description: </p>
	 * 
	 * @param invocation
	 * 
	 * @return
	 * 
	 * @throws Throwable
	 * 
	 * @see org.apache.ibatis.plugin.Interceptor#intercept(org.apache.ibatis.plugin.
	 * Invocation)
	 */
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		Object rsObj = null;
		String execMethod = null;
		String execStatement = null;
		String params = null;
		String execTime = null;
		try {
			if ((invocation.getTarget() instanceof StatementHandler)) {
				RoutingStatementHandler statementHandler = (RoutingStatementHandler) invocation.getTarget();
				BaseStatementHandler delegate = (BaseStatementHandler) ReflectHelper
						.getValueByFieldName(statementHandler, "delegate");
				MappedStatement mappedStatement = (MappedStatement) ReflectHelper.getValueByFieldName(delegate,
						"mappedStatement");
				String sqlId = mappedStatement.getId();
				String[] ms = sqlId.split("\\.");
				execMethod = ms[(ms.length - 2)] + "." + ms[(ms.length - 1)];

				String sql = statementHandler.getBoundSql().getSql();
				execStatement = sql;
				Object parameter = statementHandler.getBoundSql().getParameterObject();

				params = parameter == null ? "" : parameter.toString();
			}

			long time1 = System.currentTimeMillis();
			rsObj = invocation.proceed();
			long interval = System.currentTimeMillis() - time1;
			execTime = "" + interval;
		} finally {
			MDC.put("执行方法", execMethod);
			MDC.put("执行语句", execStatement);
			MDC.put("参数", params);
			MDC.put("执行时间", execTime);
			logger.info("SQL执行情况:");
			logger.info("执行方法:"+execMethod);
			logger.info("执行SQL语句:"+execStatement);
			logger.info("参数:"+params);
			logger.info("执行耗时:"+execTime+"毫秒");
		}

		return rsObj;
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

	/*
	 * (non-Javadoc) <p>Title: setProperties</p> <p>Description: </p>
	 * 
	 * @param properties
	 * 
	 * @see org.apache.ibatis.plugin.Interceptor#setProperties(java.util.Properties)
	 */
	@Override
	public void setProperties(Properties properties) {

	}

}
