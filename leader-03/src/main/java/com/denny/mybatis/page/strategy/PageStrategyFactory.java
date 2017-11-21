/**   
 * @Title: PageStrategyFactory.java 
 * @Package com.denny.mybatis.page.strategy 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年8月25日 上午9:42:09 
 * @version V1.0   
 */
package com.denny.mybatis.page.strategy;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.denny.mybatis.enums.DatabaseType;
import com.denny.mybatis.enums.PageStrategyType;

/** 
 * @ClassName: PageStrategyFactory 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年8月25日 上午9:42:09 
 *  
 */
@Component
public class PageStrategyFactory implements ApplicationContextAware {

	private static ApplicationContext applicationContext; 
	
	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */
	public PageStrategyFactory() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc) 
	 * <p>Title: setApplicationContext</p> 
	 * <p>Description: </p> 
	 * @param applicationContext
	 * @throws BeansException 
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext) 
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext; 
	}

	public static IPageStrategy getPageStrategy(DatabaseType databaseType) {
		IPageStrategy pageStrategy = null;
		Class strategyClass = PageStrategyType.getPageStrategyMap().get(databaseType);
		//pageStrategy = (IPageStrategy)ReflectHelper.getInstance(strategyClass);
		pageStrategy = (IPageStrategy)applicationContext.getBean(strategyClass);
		return pageStrategy;
	}

}
