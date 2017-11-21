/**   
 * @Title: OrderCreationEventListener.java 
 * @Package com.denny.jdk.event 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月3日 上午9:14:30 
 * @version V1.0   
 */
package com.denny.jdk.event;

import java.util.EventListener;

/** 
 * @ClassName: OrderCreationEventListener 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月3日 上午9:14:30 
 *  
 */
public interface OrderCreationEventListener extends EventListener {

	public void execute(Order order);
	
}
