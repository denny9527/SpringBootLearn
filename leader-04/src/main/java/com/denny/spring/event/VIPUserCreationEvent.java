/**   
 * @Title: VIPUserCreationEvent.java 
 * @Package com.denny.spring.event 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月3日 下午12:57:48 
 * @version V1.0   
 */
package com.denny.spring.event;

import org.springframework.context.ApplicationEvent;

/** 
 * @ClassName: VIPUserCreationEvent 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月3日 下午12:57:48 
 *  
 */
public class VIPUserCreationEvent /*extends ApplicationEvent*/ {

	/** 
	 * @Fields serialVersionUID : TODO 
	 */ 
	private static final long serialVersionUID = -8189792660094125081L;

	private String userName;

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p> 
	 * @param source 
	 */
//	public VIPUserCreationEvent(String userName) {
//		super(userName);
//	}
//
//	public final String getUserName() {
//		return (String)getSource();
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
	 * @param userName 
	 */
	public VIPUserCreationEvent(String userName) {
		super();
		this.userName = userName;
	}

	/** 
	 * @return userName 
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
