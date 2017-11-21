/**   
 * @Title: MyInvocationBean.java 
 * @Package com.denny.spring.injection 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月3日 下午5:25:42 
 * @version V1.0   
 */
package com.denny.spring.injection;

import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @ClassName: MyInvocationBean
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年9月3日 下午5:25:42
 * 
 */
@Component("myInvocationBean")
public class MyInvocationBean {
	
	public static final Logger logger = LoggerFactory.getLogger(MyInvocationBean.class);

	//@Autowired
	//@Qualifier(value = "myBean_2")

	// @Resource(type = MyBean_1.class)
	// @Autowired(required = false)
	// @Resource(name = "myBean_1")
	
	//@Resource(name = "myBean_1")
	private MyBaseBean myBaseBean;
	
	@Resource
	private Set<MyBaseBean> myBaseBeanList;
	
	@Resource
	private Map<String, MyBaseBean> myBaseBeanMap;
	
	//@Autowired
	
	@Resource
	private ApplicationContext context;

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
//	@Autowired
//	public MyInvocationBean(MyBaseBean myBaseBean) {
//		this.myBaseBean = myBaseBean;
//	}
	
	private MyHelloBean myHelloBean;
	
	@Autowired
	public MyInvocationBean(MyHelloBean myHelloBean) {
		this.myHelloBean = myHelloBean;
	}

	public void handle() {
		myBaseBean.execute();
	}

	public void printInjectionBeanList() {
		logger.info("myBaseBeanList:"+this.myBaseBeanList.toString());
	}
	
	public void printInjectionBeanMap() {
		logger.info("myBaseBeanMap:"+this.myBaseBeanMap);
	}
	
	public void printMyHelloBean() {
		logger.info("myHelloBean:"+this.myHelloBean);
	}
	
	public void printApplicationContext() {
		logger.info("applicationContext:"+this.context);
	}
	
	public void printMyBaseBean() {
		logger.info("myBaseBean:"+this.myBaseBean);
	}
	
	
	//@Autowired
	//@Qualifier(value = "myBean_1")
	
	@Resource(type = MyBean_1.class)
	public void setBaseBean(MyBaseBean myBaseBean) {
		this.myBaseBean = myBaseBean;
	}

}
