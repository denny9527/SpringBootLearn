/**   
 * @Title: MyBean_1.java 
 * @Package com.denny.spring.injection 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月3日 下午5:22:55 
 * @version V1.0   
 */
package com.denny.spring.injection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.denny.spring.event.EmailService;

/** 
 * @ClassName: MyBean_1 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月3日 下午5:22:55 
 *  
 */
//@Component("myBean_1")
@Component()
public class MyBean_1 extends MyBaseBean {

	public static final Logger logger = LoggerFactory.getLogger(MyBean_1.class);
	
	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */
	public MyBean_1() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc) 
	 * <p>Title: execute</p> 
	 * <p>Description: </p>  
	 * @see com.denny.spring.injection.MyBaseBean#execute() 
	 */
	@Override
	public void execute() {
		logger.info("MyBean_1 执行!");
	}

}
