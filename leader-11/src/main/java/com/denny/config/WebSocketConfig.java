/**   
 * @Title: WebSocketConfig.java 
 * @Package com.denny.config 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年11月5日 下午2:41:56 
 * @version V1.0   
 */
package com.denny.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/** 
 * @ClassName: WebSocketConfig 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年11月5日 下午2:41:56 
 *  
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	/* (non-Javadoc) 
	 * <p>Title: configureMessageBroker</p> 
	 * <p>Description: </p> 
	 * @param registry 
	 * @see org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer#configureMessageBroker(org.springframework.messaging.simp.config.MessageBrokerRegistry) 
	 */
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
        //代理将会处理前缀为“/topic”和“/queue”的消息
        //(以“/topic”和“/queue”作为前缀)发送到代理上的消息，其中也包括@MessageMapping注解方法的返回值所形成的消息，将会路由到代理上，并最终发送到订阅这些目的地的客户端。
		registry.enableSimpleBroker("/topic"); //设置服务器广播消息的基础路径
		 //发往应用程序的消息将会带有“/app”前缀。
        //（/app前缀）以应用程序为目的地的消息将会直接路由到带有@MessageMapping注解的控制器方法中
		registry.setApplicationDestinationPrefixes("/app"); //设置服务器广播消息的基础路径
	}

	/* (non-Javadoc) 
	 * <p>Title: registerStompEndpoints</p> 
	 * <p>Description: </p> 
	 * @param arg0 
	 * @see org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer#registerStompEndpoints(org.springframework.web.socket.config.annotation.StompEndpointRegistry) 
	 */
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
        //websocket-test就是websocket的端点，客户端需要注册这个端点进行链接，withSockJS允许客户端利用sockjs进行浏览器兼容性处理
		registry.addEndpoint("/websocket-test").withSockJS();
	}

}
