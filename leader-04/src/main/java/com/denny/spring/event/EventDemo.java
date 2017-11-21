/**   
 * @Title: EventDemo.java 
 * @Package com.denny.spring.event 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月3日 下午12:09:21 
 * @version V1.0   
 */
package com.denny.spring.event;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.config.TaskExecutorFactoryBean;

import com.denny.utils.UUIDUtil;

/** 
 * @ClassName: EventDemo 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月3日 下午12:09:21 
 *  
 */
@Configuration
@EnableAsync
//@ImportResource(locations = {"classpath:spring-config.xml"})
public class EventDemo {

//	@Bean("taskExecutor")
//	public TaskExecutorFactoryBean getTaskExecutorFactoryBean() {
//		TaskExecutorFactoryBean taskExecutorFactoryBean = new TaskExecutorFactoryBean();
//		taskExecutorFactoryBean.setPoolSize("10");
//		taskExecutorFactoryBean.setQueueCapacity(200);
//		return taskExecutorFactoryBean;
//	}
//	
//	@Bean("applicationEventMulticaster")//名称必须为:applicationEventMulticaster
//	public SimpleApplicationEventMulticaster getEventMulticaster() {
//		SimpleApplicationEventMulticaster eventMulticaster = new SimpleApplicationEventMulticaster();
//		eventMulticaster.setTaskExecutor(getTaskExecutorFactoryBean().getObject());
//		return eventMulticaster;
//	}

	/** 
	 * @Title: main 
	 * @Description: TODO 
	 * @param @param args
	 * @return void
	 * @throws 
	 */
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.denny.spring.event");
		Order order = new Order();
		order.setOrderSerialNum(UUIDUtil.generateUUID());
		order.setProductName("鼠标");
		order.setProductCount(2l);
		order.setProductUnitPrice(new BigDecimal(300));
		order.setOrderTotalPrice(order.getProductUnitPrice().multiply(new BigDecimal(order.getProductCount())));
		order.setBuyerName("张三");
		order.setSellerName("李四");
		order.setOrderTime(new Date());
		
		OrderService orderService = (OrderService)context.getBean("orderService");
		orderService.createOrder(order);
	}

}
