/**   
 * @Title: ExtendServiceImpl.java 
 * @Package com.denny.common.extend 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月15日 下午4:46:21 
 * @version V1.0   
 */
package com.denny.common.extend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import com.denny.spring.aop.ServiceAspect;

/** 
 * @ClassName: ExtendServiceImpl 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月15日 下午4:46:21 
 *  
 */
@Service("extendService")
public class ExtendServiceImpl implements ExtendService {

	private final static Logger logger = LoggerFactory.getLogger(ExtendServiceImpl.class);
	
	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */
	public ExtendServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc) 
	 * <p>Title: exec</p> 
	 * <p>Description: </p>  
	 * @see com.denny.common.extend.ExtendService#exec() 
	 */
	@Override
	public void exec() {
		logger.info("扩展服务执行！");
	}

}
