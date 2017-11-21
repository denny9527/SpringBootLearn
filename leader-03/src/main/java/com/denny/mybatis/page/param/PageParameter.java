/**   
 * @Title: PageParameter.java 
 * @Package com.denny.mybatis.page.param 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年8月24日 下午2:21:59 
 * @version V1.0   
 */
package com.denny.mybatis.page.param;

/**
 * @ClassName: PageParameter
 * @Description: 基础分页类
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年8月24日 下午2:21:59
 * 
 */
public class PageParameter implements IPageParameter {

	/**
	 * 默认每页条数
	 */
	public static final int PAGE_LIMIT_DEFAULT = 20;

	/**
	 * 分页开始index
	 */
	private int start;


	/**
	 * 每页限制条数
	 */
	private int limit = 20;

	/**
	 * 是否需要总条数
	 */
	private boolean requireTotal = true;

	/**
	 * 总条数
	 */
	private int total;

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	public PageParameter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return start
	 */
	@Override
	public int getStart() {
		return start;
	}

	/**
	 * @param start
	 *            the start to set
	 */
	public void setStart(int start) {
		this.start = start;
	}

	/**
	 * @return limit
	 */
	@Override
	public int getLimit() {
		return limit;
	}

	/**
	 * @param limit
	 *            the limit to set
	 */
	public void setLimit(int limit) {
		this.limit = limit;
	}

	/**
	 * @return requireTotal
	 */
	@Override
	public boolean isRequireTotal() {
		return requireTotal;
	}

	/**
	 * @param requireTotal
	 *            the requireTotal to set
	 */
	public void setRequireTotal(boolean requireTotal) {
		this.requireTotal = requireTotal;
	}

	/**
	 * @return total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	@Override
	public void setTotal(int total) {
		this.total = total;
	}

}
