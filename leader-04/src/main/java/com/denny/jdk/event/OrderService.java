/**   
 * @Title: OrderService.java 
 * @Package com.denny.jdk.event 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月2日 下午8:05:59 
 * @version V1.0   
 */
package com.denny.jdk.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: OrderService
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年9月2日 下午8:05:59
 * 
 */
public class OrderService {

	private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

	private OrderCreationEventPublisher eventPublisher;
	
	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	public OrderService(OrderCreationEventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
	}

	/** 
	 * @return eventPublisher 
	 */
	public OrderCreationEventPublisher getEventPublisher() {
		return eventPublisher;
	}

	/**
	 * @param eventPublisher the eventPublisher to set
	 */
	public void setEventPublisher(OrderCreationEventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
	}

	public void createOrder(Order order) {
		StringBuffer info = new StringBuffer();
		info.append("创建订单成功,订单信息:\n");
		info.append("产品名称："+order.getProductName()+"\n");
		info.append("产品数量："+order.getProductCount()+"\n");
		info.append("订单总价:："+order.getOrderTotalPrice().toString()+"\n");
		info.append("卖家姓名:"+order.getSellerName()+"\n");
		info.append("买家姓名："+order.getBuyerName());
		logger.info(info.toString());
		//发布事件
		OrderCreationEvent event = new OrderCreationEvent(order);
		eventPublisher.publishEvent(event);
	}

}
