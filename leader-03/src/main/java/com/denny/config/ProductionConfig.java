/**   
 * @Title: ProductionConfig.java 
 * @Package com.denny.config 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年8月25日 下午5:51:21 
 * @version V1.0   
 */
package com.denny.config;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.denny.properties.JDBCProperties;

/** 
 * @ClassName: ProductionConfig 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年8月25日 下午5:51:21 
 *  
 */
@Configuration
@Profile("prod")
public class ProductionConfig {

}
