/**   
 * @Title: OrderCreationEmailListener.java 
 * @Package com.denny.jdk.event 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月2日 下午7:47:29 
 * @version V1.0   
 */
package com.denny.jdk.event;

import java.util.EventListener;

/** 
 * @ClassName: OrderCreationEmailListener 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月2日 下午7:47:29 
 *  
 */
public class OrderCreationEmailListener implements OrderCreationEventListener {
	
	private MsgService msgService = new MsgService();
	
	@Override
	public void execute(Order order) {
		msgService.sendOrderCreationEmail(order);
	}

}
