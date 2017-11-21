/**   
 * @Title: VIPUserDetector.java 
 * @Package com.denny.jdk.event 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月2日 下午8:25:54 
 * @version V1.0   
 */
package com.denny.spring.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/** 
 * @ClassName: VIPUserDetector 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月2日 下午8:25:54 
 *  
 */
@Component
public class VIPUserDetector {
	
	@Autowired
	private VIPUserService vipUserService;
	
	
	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */
	public VIPUserDetector(VIPUserService vipUserService) {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @Title: createVIPUser 
	 * @Description: TODO 
	 * @param @param userName
	 * @return void
	 * @throws
	 */
	@EventListener(classes = {OrderCreationEvent.class},
			condition = "#orderEvent.getOrder().orderTotalPrice.floatValue() > 500")
	public void createVIPUser(OrderCreationEvent orderEvent) {
		this.vipUserService.createVIPUser(orderEvent.getOrder().getBuyerName());
	}

}
