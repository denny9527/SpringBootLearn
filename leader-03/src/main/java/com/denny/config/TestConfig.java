/**   
 * @Title: TestConfig.java 
 * @Package com.denny 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年8月25日 下午2:12:11 
 * @version V1.0   
 */
package com.denny.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.denny.cmomon.data.TestDataInitialization;
import com.denny.properties.JDBCProperties;


/** 
 * @ClassName: TestConfig 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年8月25日 下午2:12:11 
 *  
 */
@Configuration
@AutoConfigureAfter({MyBatisConfig.class})
@Profile("test")
public class TestConfig {

	@Bean
	public TestDataInitialization getTestDataInitialization() {
		TestDataInitialization testDataInitialization = new TestDataInitialization();
		return testDataInitialization;
	}
}
