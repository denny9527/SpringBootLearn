/**   
 * @Title: OrderCreationEventPublisher.java 
 * @Package com.denny.jdk.event 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月3日 上午9:10:22 
 * @version V1.0   
 */
package com.denny.jdk.event;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: OrderCreationEventPublisher
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年9月3日 上午9:10:22
 * 
 */
public class OrderCreationEventPublisher {

	private static final Logger logger = LoggerFactory.getLogger(OrderCreationEventPublisher.class);

	private List<OrderCreationEventListener> listeners = new ArrayList<OrderCreationEventListener>();

	public void addListener(OrderCreationEventListener listener) {
		listeners.add(listener);
	}

	public void removeListener(OrderCreationEventListener listener) {
		if (listeners.contains(listener)) {
			listeners.remove(listener);
		}
	}

	public void removeAllListener() {
		listeners.clear();
	}

	protected void publishEvent(OrderCreationEvent event) {
		for (OrderCreationEventListener listener : listeners) {
			listener.execute(event.getOrder());
		}
	}

}
