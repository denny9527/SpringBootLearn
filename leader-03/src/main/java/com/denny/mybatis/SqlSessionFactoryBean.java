/**   
 * @Title: SqlSessionFactoryBean.java 
 * @Package com.denny.mybatis 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年8月25日 下午2:14:41 
 * @version V1.0   
 */
package com.denny.mybatis;

import java.io.IOException;

import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.denny.user.common.service.UserInfoServiceImpl;

/** 
 * @ClassName: SqlSessionFactoryBean 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年8月25日 下午2:14:41 
 *  
 */
public class SqlSessionFactoryBean extends org.mybatis.spring.SqlSessionFactoryBean {

	private static final Logger logger = LoggerFactory.getLogger(SqlSessionFactoryBean.class);
	
	/* (non-Javadoc) 
	 * <p>Title: buildSqlSessionFactory</p> 
	 * <p>Description: </p> 
	 * @return
	 * @throws IOException 
	 * @see org.mybatis.spring.SqlSessionFactoryBean#buildSqlSessionFactory() 
	 */
	@Override
	protected SqlSessionFactory buildSqlSessionFactory() throws IOException {
		logger.info("mybatis 开始启动!");
		SqlSessionFactory sqlSessionFactory = super.buildSqlSessionFactory();
		logger.info("mybatis 完成启动!");
		return sqlSessionFactory;
	}

}
