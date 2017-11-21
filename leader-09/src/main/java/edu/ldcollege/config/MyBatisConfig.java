/**   
 * @Title: MyBatisConfig.java 
 * @Package com.denny.config 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年8月25日 下午5:19:37 
 * @version V1.0   
 */
package edu.ldcollege.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.springframework.transaction.config.TransactionManagementConfigUtils;

import com.denny.mybatis.interceptor.PaginationInterceptor;

/**
 * @ClassName: MyBatisConfig
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年8月25日 下午5:19:37
 * 
 */
@Configuration
@MapperScan("edu.ldcollege.dao")
public class MyBatisConfig implements TransactionManagementConfigurer {

	@Autowired
	private DataSource dataSource;

	@Bean("mybatisSqlSessionFactory")
	public SqlSessionFactory getMyBatisSqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		Resource[] resources = new PathMatchingResourcePatternResolver()
				.getResources("classpath*:edu/ldcollege/dao/*.xml");
		sqlSessionFactoryBean.setMapperLocations(resources);

		// 配置分页拦截器
		Interceptor[] plugins = new Interceptor[] { getPaginationInterceptor() };
		sqlSessionFactoryBean.setPlugins(plugins);
		return sqlSessionFactoryBean.getObject();

	}

	@Bean("paginationInterceptor")
	public PaginationInterceptor getPaginationInterceptor() {
		PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
		paginationInterceptor.setPageMapper(".*WithPage.*");
		return paginationInterceptor;
	}

	@Bean("sqlSessionTemplate")
	public SqlSessionTemplate getSqlSessionTemplate() throws Exception {
		SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(getMyBatisSqlSessionFactory());
		return sqlSessionTemplate;
	}

	@Override
	@Bean(name = "transactionManager")
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource);
		return transactionManager;
	}

}
