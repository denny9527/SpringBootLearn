/**   
 * @Title: MyHelloBean.java 
 * @Package com.denny.spring.injection 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月5日 上午10:04:06 
 * @version V1.0   
 */
package com.denny.spring.injection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/** 
 * @ClassName: MyHelloBean 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月5日 上午10:04:06 
 *  
 */
@Component
public class MyHelloBean {

	public static final Logger logger = LoggerFactory.getLogger(MyHelloBean.class);
	
	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */
	public MyHelloBean() {
		// TODO Auto-generated constructor stub
	}
	
	public void execute() {
		logger.info("MyHelloBean执行!");
	}


}
