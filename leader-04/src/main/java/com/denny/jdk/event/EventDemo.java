/**   
 * @Title: EventDemo.java 
 * @Package com.denny.jdk.event 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月3日 上午9:24:52 
 * @version V1.0   
 */
package com.denny.jdk.event;

import java.math.BigDecimal;
import java.util.Date;

import com.denny.utils.UUIDUtil;

/**
 * @ClassName: EventDemo
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年9月3日 上午9:24:52
 * 
 */
public class EventDemo {

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	public EventDemo() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @Title: main @Description: TODO @param @param args @return void @throws
	 */
	public static void main(String[] args) {
		Order order = new Order();
		order.setOrderSerialNum(UUIDUtil.generateUUID());
		order.setProductName("可口可乐");
		order.setProductCount(10l);
		order.setProductUnitPrice(new BigDecimal(2.5));
		order.setOrderTotalPrice(order.getProductUnitPrice().multiply(new BigDecimal(order.getProductCount())));
		order.setBuyerName("张三");
		order.setSellerName("李四");
		order.setOrderTime(new Date());
		
		OrderCreationEventPublisher eventPublisher = new OrderCreationEventPublisher();
		eventPublisher.addListener(new OrderCreationEmailListener());
		eventPublisher.addListener(new OrderCreationSMSListener());
		OrderService orderService = new OrderService(eventPublisher);
		orderService.createOrder(order);
		
	}

}
