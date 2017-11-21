/**   
 * @Title: OrderCreationEvent.java 
 * @Package com.denny.jdk.event 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月2日 下午7:44:33 
 * @version V1.0   
 */
package com.denny.jdk.event;

import java.util.EventObject;

/** 
 * @ClassName: OrderCreationEvent 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月2日 下午7:44:33 
 *  
 */
public class OrderCreationEvent extends EventObject {

	private Order order;
	/** 
	 * @Fields serialVersionUID : TODO 
	 */ 
	private static final long serialVersionUID = -9172174160828310550L;
	
	
	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p> 
	 * @param source 
	 */
//	public OrderCreationEvent(Order order) {
//		super(order);
//	}

//	public final Order getOrder() {
//		return (Order)this.getSource();
//	}
	
	/* (non-Javadoc) 
	 * <p>Title: toString</p> 
	 * <p>Description: </p> 
	 * @return 
	 * @see java.util.EventObject#toString() 
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p> 
	 * @param order 
	 */
	public OrderCreationEvent(Order order) {
		super(order);
		this.order = order;
	}

	/** 
	 * @return order 
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

}
