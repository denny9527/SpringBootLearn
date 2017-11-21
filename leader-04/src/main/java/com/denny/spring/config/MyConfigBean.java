/**   
 * @Title: MyConfigBean.java 
 * @Package com.denny.spring.config 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月3日 下午8:01:41 
 * @version V1.0   
 */
package com.denny.spring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

/** 
 * @ClassName: MyConfigBean 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月3日 下午8:01:41 
 *  
 */
@Configurable(autowire = Autowire.BY_TYPE)//非Spring容器外实例化,但仍由Spring容器进行装配(依赖注入)
public class MyConfigBean {

	public static final Logger logger = LoggerFactory.getLogger(MyBean.class);
	
	@Autowired
	private MyBean myBean;
	
	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */
	public MyConfigBean() {
		// TODO Auto-generated constructor stub
	}

	public void handle() {
		logger.info("调用MyBean的exec方法!\n");
		myBean.exec();
	}

	/** 
	 * @return myBean 
	 */
	public MyBean getMyBean() {
		return myBean;
	}

	/**
	 * @param myBean the myBean to set
	 */
	public void setMyBean(MyBean myBean) {
		this.myBean = myBean;
	}
	
}
