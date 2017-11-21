/**
 * @Title: ILdHomeworkFBDao.java
 * @Package: edu.ldcollege.dao
 * @Description: 
 * @author Zhang Kui
 * @date 2017年10月14日 下午03:47:49
 * @version V1.0.0
 */
package edu.ldcollege.dao;

import java.util.List;

import com.denny.common.dao.IBaseDao;
import edu.ldcollege.domain.LdHomeworkFB;
import edu.ldcollege.query.LdHomeworkFBQuery;

/**
 * @ClassName: ILdHomeworkFBDao
 * @Description: 
 * @author Zhang Kui
 * @date 2017年10月14日 下午03:47:49
 * @version 1.0.0 
 */
public interface ILdHomeworkFBDao extends IBaseDao<LdHomeworkFB, Long, LdHomeworkFBQuery> {
	
	public List<LdHomeworkFB> queryHomeworkAppraiseList(Long homeworkId);
	
}