/**   
 * @Title: WebSocketSecurityConfig.java 
 * @Package com.denny.config 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年11月5日 下午4:14:43 
 * @version V1.0   
 */
package com.denny.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;

/**
 * @ClassName: WebSocketSecurityConfig
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年11月5日 下午4:14:43
 * 
 */
@Configuration
public class WebSocketSecurityConfig extends AbstractSecurityWebSocketMessageBrokerConfigurer {

	@Override
	protected void configureInbound(MessageSecurityMetadataSourceRegistry messages) {
		messages.nullDestMatcher().authenticated()
		.simpDestMatchers("/app/**").hasRole("user")
		.simpSubscribeDestMatchers("/topic/**").hasRole("user")
		.anyMessage().denyAll();
	}
	
    @Override
    protected boolean sameOriginDisabled() {
        return true;
    }

}

