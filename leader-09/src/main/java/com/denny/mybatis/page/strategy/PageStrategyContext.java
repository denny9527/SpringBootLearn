/**   
 * @Title: PageStrategyContext.java 
 * @Package com.denny.mybatis.page.strategy 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年8月25日 上午10:45:51 
 * @version V1.0   
 */
package com.denny.mybatis.page.strategy;

import com.denny.mybatis.page.param.IPageParameter;

/** 
 * @ClassName: PageStrategyContext 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年8月25日 上午10:45:51 
 *  
 */
public class PageStrategyContext {
	
	private IPageStrategy pageStrategy;
	
	private IPageParameter pageParameter;
	
	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p> 
	 * @param pageStrategy
	 * @param pageParameter 
	 */
	public PageStrategyContext(IPageStrategy pageStrategy, IPageParameter pageParameter) {
		super();
		this.pageStrategy = pageStrategy;
		this.pageParameter = pageParameter;
	}

	/** 
	 * @return pageStrategy 
	 */
	public IPageStrategy getPageStrategy() {
		return pageStrategy;
	}

	/**
	 * @param pageStrategy the pageStrategy to set
	 */
	public void setPageStrategy(IPageStrategy pageStrategy) {
		this.pageStrategy = pageStrategy;
	}

	/** 
	 * @return pageParameter 
	 */
	public IPageParameter getPageParameter() {
		return pageParameter;
	}

	/**
	 * @param pageParameter the pageParameter to set
	 */
	public void setPageParameter(IPageParameter pageParameter) {
		this.pageParameter = pageParameter;
	}

	/**
	 * 构建分页语句
	 * @Title: buildPagingSql 
	 * @Description: TODO 
	 * @param @param querySql
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String buildPagingSql(String querySql) {
		return pageStrategy.generatePageSql(querySql, pageParameter.getStart(), pageParameter.getLimit());
	}

}
