/**
 * @Title: ILdHomeworkDao.java
 * @Package: edu.ldcollege.dao
 * @Description: 
 * @author Zhang Kui
 * @date 2017年10月14日 下午03:47:49
 * @version V1.0.0
 */
package edu.ldcollege.dao;

import java.util.List;
import java.util.Map;

import com.denny.common.dao.IBaseDao;
import edu.ldcollege.domain.LdHomework;
import edu.ldcollege.query.LdHomeworkQuery;

/**
 * @ClassName: ILdHomeworkDao
 * @Description: 
 * @author Zhang Kui
 * @date 2017年10月14日 下午03:47:49
 * @version 1.0.0 
 */
public interface ILdHomeworkDao extends IBaseDao<LdHomework, Long, LdHomeworkQuery> {
	
	public List<LdHomework> queryCorrectHomework(LdHomeworkQuery ldHomeworkQuery);

	public Long updateAppraiseInfo(Map<String, Object> paramMap);

}