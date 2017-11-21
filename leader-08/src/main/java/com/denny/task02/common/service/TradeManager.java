/**   
 * @Title: TradeService.java 
 * @Package com.denny.task02.common.service 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年10月7日 下午12:20:11 
 * @version V1.0   
 */
package com.denny.task02.common.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.denny.common.IBaseService;
import com.denny.task02.common.domain.Order;
import com.denny.task02.common.domain.OrderOperationLog;
import com.denny.task02.common.domain.SMSlog;

/**
 * @ClassName: TradeService
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年10月7日 下午12:20:11
 * 
 */
@Service("tradeManager")
public class TradeManager {

	private final static Logger logger = LoggerFactory.getLogger(TradeManager.class);
	
	@Autowired
	private IBaseService<Order> orderService;

	@Autowired
	private IBaseService<OrderOperationLog> orderOperationLogService;

	@Autowired
	private MessageManager messageManager;

	@Transactional
	public void createOrder(Order order) {
		orderService.save(order);
		OrderOperationLog orderOperationLog = new OrderOperationLog(null, order.getOrderId(),
				"订单(订单号:" + order.getOrderId() + ")创建成功", order.getUserAccount(), "0", new Date());
		orderOperationLogService.save(orderOperationLog);
		SMSlog smsLog = new SMSlog(null, order.getUserAccount(), order.getPhoneNumber(),
				"尊敬的用户的订单(订单号:" + order.getOrderId() + ")已创建成功", new Date());
		try {
			messageManager.sendSMS(smsLog);
		} catch (Exception e) {
			logger.info("执行其他的业务流程!");
		}
	}

}
