/**   
 * @Title: MsgService.java 
 * @Package com.denny.jdk.event 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月3日 上午8:24:37 
 * @version V1.0   
 */
package com.denny.jdk.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: MsgService
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年9月3日 上午8:24:37
 * 
 */
public class MsgService {

	private static final Logger logger = LoggerFactory.getLogger(MsgService.class);

	public void sendOrderCreationEmail(Order order) {
		StringBuffer info = new StringBuffer();
		info.append("下单成功邮件\n");
		info.append("尊敬的"+order.getBuyerName()+"先生/女士:\n");
		info.append("你的订单:"+order.getOrderSerialNum()+"已成功提交!");
		logger.info(info.toString());
	}
	
	public void sendOrderCreationSMS(Order order) {
		StringBuffer info = new StringBuffer();
		info.append("下单成功短信\n");
		info.append("尊敬的"+order.getBuyerName()+"先生/女士:\n");
		info.append("你的订单:"+order.getOrderSerialNum()+"已成功提交!");
		logger.info(info.toString());
	}

}
