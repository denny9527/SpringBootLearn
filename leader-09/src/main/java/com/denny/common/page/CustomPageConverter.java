/**   
 * @Title: CustomPageConverter.java 
 * @Package com.denny.cmomon.page 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年8月24日 下午5:27:14 
 * @version V1.0   
 */
package com.denny.common.page;

import com.denny.mybatis.page.param.IPageConverter;
import com.denny.mybatis.page.param.IPageParameter;
import com.denny.mybatis.page.param.PageParameter;

/** 
 * @ClassName: CustomPageConverter 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年8月24日 下午5:27:14 
 *  
 */
public class CustomPageConverter implements IPageConverter<QueryPage> {

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */
	public CustomPageConverter() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc) 
	 * <p>Title: toPage</p> 
	 * <p>Description: </p> 
	 * @param paramT
	 * @return 
	 * @see com.denny.mybatis.page.param.IPageConverter#toPage(java.lang.Object) 
	 */
	@Override
	public IPageParameter toPage(QueryPage paramT) {
		PageParameter pageParameter = new PageParameter();
		pageParameter.setLimit(paramT.getPageSize());
		pageParameter.setRequireTotal(true);
		return pageParameter;
	}

	/* (non-Javadoc) 
	 * <p>Title: returnTotal</p> 
	 * <p>Description: </p> 
	 * @param paramT
	 * @param paramInt 
	 * @see com.denny.mybatis.page.param.IPageConverter#returnTotal(java.lang.Object, int) 
	 */
	@Override
	public void returnTotal(IPageParameter pageParameter, QueryPage paramT, int paramInt) {
		paramT.setTotalItem(paramInt);
		PageParameter parameterInst = (PageParameter)pageParameter;
		parameterInst.setStart(paramT.getPageFristItem());
	}

}
