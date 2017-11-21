/**   
 * @Title: OrderService.java 
 * @Package com.denny.jdk.event 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月2日 下午8:05:59 
 * @version V1.0   
 */
package com.denny.spring.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * @ClassName: OrderService
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年9月2日 下午8:05:59
 * 
 */
@Service("orderService")
public class OrderService /*implements ApplicationEventPublisherAware*/ {

	private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
	
	//private ApplicationEventPublisher applicationEventPublisher;
	
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;
	
	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	public OrderService() {

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


	public void createOrder(Order order) {
		StringBuffer info = new StringBuffer();
		info.append("创建订单成功,订单信息:");
		info.append("产品名称："+order.getProductName()+" ");
		info.append("产品数量："+order.getProductCount()+" ");
		info.append("订单总价:："+order.getOrderTotalPrice().toString()+" ");
		info.append("卖家姓名:"+order.getSellerName()+" ");
		info.append("买家姓名："+order.getBuyerName());
		logger.info(info.toString());
		this.applicationEventPublisher.
			publishEvent(new OrderCreationEvent(order));
	}

}
