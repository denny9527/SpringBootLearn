/**   
 * @Title: OrgDao.java 
 * @Package com.denny.common.user 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月5日 下午1:04:05 
 * @version V1.0   
 */
package com.denny.common.org;

import java.util.List;

import com.denny.common.BaseDao;
import com.denny.ioc.annotation.Bean;

/** 
 * @ClassName: OrgDao 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月5日 下午1:04:05 
 *  
 */
@Bean("orgDao")
public class OrgDao extends BaseDao<Org> {

	/* (non-Javadoc) 
	 * <p>Title: save</p> 
	 * <p>Description: </p> 
	 * @param t
	 * @return 
	 * @see com.denny.common.BaseDao#save(java.lang.Object) 
	 */
	@Override
	public int save(Org t) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc) 
	 * <p>Title: delete</p> 
	 * <p>Description: </p> 
	 * @param id
	 * @return 
	 * @see com.denny.common.BaseDao#delete(java.lang.Long) 
	 */
	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc) 
	 * <p>Title: update</p> 
	 * <p>Description: </p> 
	 * @param t
	 * @return 
	 * @see com.denny.common.BaseDao#update(java.lang.Object) 
	 */
	@Override
	public int update(Org t) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc) 
	 * <p>Title: queryList</p> 
	 * <p>Description: </p> 
	 * @param t
	 * @return 
	 * @see com.denny.common.BaseDao#queryList(java.lang.Object) 
	 */
	@Override
	public List<Org> queryList(Org t) {
		// TODO Auto-generated method stub
		return null;
	}

}
