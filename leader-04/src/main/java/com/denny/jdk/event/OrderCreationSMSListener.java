/**   
 * @Title: OrderCreationSMSListener.java 
 * @Package com.denny.jdk.event 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月3日 上午9:09:01 
 * @version V1.0   
 */
package com.denny.jdk.event;

/** 
 * @ClassName: OrderCreationSMSListener 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月3日 上午9:09:01 
 *  
 */
public class OrderCreationSMSListener implements OrderCreationEventListener {
	
	private MsgService msgService = new MsgService();
	
	@Override
	public void execute(Order order) {
		msgService.sendOrderCreationSMS(order);
	}

}
