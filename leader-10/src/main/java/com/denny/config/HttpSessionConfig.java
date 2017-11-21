/**   
 * @Title: HttpSessionConfig.java 
 * @Package com.denny.config 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年8月28日 上午6:32:54 
 * @version V1.0   
 */
package com.denny.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @ClassName: HttpSessionConfig
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年8月28日 上午6:32:54
 * 
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 5000)
public class HttpSessionConfig {
}
