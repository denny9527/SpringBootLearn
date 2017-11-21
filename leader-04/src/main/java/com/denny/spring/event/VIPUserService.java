/**   
 * @Title: VIPUserService.java 
 * @Package com.denny.jdk.event 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月2日 下午8:15:58 
 * @version V1.0   
 */
package com.denny.spring.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/** 
 * @ClassName: VIPUserService 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月2日 下午8:15:58 
 *  
 */
@Component
public class VIPUserService /*implements ApplicationEventPublisherAware*/ {
	
	private static final Logger logger = LoggerFactory.getLogger(VIPUserService.class);

	//private ApplicationEventPublisher applicationEventPublisher;
	
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;
	
	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */
	public VIPUserService() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc) 
	 * <p>Title: setApplicationEventPublisher</p> 
	 * <p>Description: </p> 
	 * @param applicationEventPublisher 
	 * @see org.springframework.context.ApplicationEventPublisherAware#setApplicationEventPublisher(org.springframework.context.ApplicationEventPublisher) 
	 */
//	@Override
//	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
//		this.applicationEventPublisher = applicationEventPublisher;
//	}


	/**
	 * 创建VIP用户
	 * @Title: createVIPUser 
	 * @Description: TODO 
	 * @param @param userName
	 * @return void
	 * @throws
	 */
	public void createVIPUser(String userName) {
		logger.info("VIP用户创建成功, 信息为:[用户:"+userName+"升级为VIP用户!]");
		VIPUserCreationEvent event = new VIPUserCreationEvent(userName);
		this.applicationEventPublisher.publishEvent(event);
	}

}
