/**   
 * @Title: MyBatisMapperScannerConfig.java 
 * @Package com.denny.config 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年8月26日 下午3:00:05 
 * @version V1.0   
 */
package com.denny.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/** 
 * @ClassName: MyBatisMapperScannerConfig 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年8月26日 下午3:00:05 
 *  
 */
@Configuration
@AutoConfigureAfter({MyBatisConfig.class})
@EnableTransactionManagement
public class MyBatisMapperScannerConfig {

	@Bean
	public MapperScannerConfigurer getMapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("mybatisSqlSessionFactory");
		mapperScannerConfigurer.setBasePackage("com.denny.user.common.dao");
		return mapperScannerConfigurer;
	}

}
