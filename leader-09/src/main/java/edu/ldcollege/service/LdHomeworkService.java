/**   
 * @Title: LdHomeworkService.java 
 * @Package edu.ldcollege.service 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年10月14日 下午4:10:12 
 * @version V1.0   
 */
package edu.ldcollege.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.internal.cglib.core.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.ldcollege.dao.ILdHomeworkDao;
import edu.ldcollege.dao.ILdHomeworkFBDao;
import edu.ldcollege.domain.LdHomework;
import edu.ldcollege.domain.LdHomeworkFB;
import edu.ldcollege.enums.AppraiseFlagEnum;
import edu.ldcollege.enums.BestFlagEnum;
import edu.ldcollege.enums.ClassEnum;
import edu.ldcollege.enums.CorrectFlagEnum;
import edu.ldcollege.enums.CourseEnum;
import edu.ldcollege.query.LdHomeworkFBQuery;
import edu.ldcollege.query.LdHomeworkQuery;

/** 
 * @ClassName: LdHomeworkService 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年10月14日 下午4:10:12 
 *  
 */
@Service("ldHomeworkService")
public class LdHomeworkService {
	
	@Autowired
	private ILdHomeworkFBDao ldHomeworkFBDao;
	
	@Autowired
	private ILdHomeworkDao ldHomeworkDao;
	
	@Value("${upload.dir}")
	private String uploadDir;

	@Transactional
	public Long saveHomework(LdHomework homework) {
		homework.setCorrectFlag(CorrectFlagEnum.NO_CORRECT.getCode());
		homework.setBestFlag(BestFlagEnum.NO.getCode());
		homework.setNegativeCount(0l);
		homework.setStarCount(0l);
		LdHomeworkQuery query = new LdHomeworkQuery();
		query.setUserId(homework.getUserId());
		query.setClassId(homework.getClassId());
		query.setLessonId(homework.getLessonId());
		List<LdHomework> ldHomeworkList = ldHomeworkDao.queryList(query);
		List<Long> idList = new ArrayList<Long>();
		if(null != ldHomeworkList && ldHomeworkList.size() > 0) {
			for(LdHomework ldHomework : ldHomeworkList) {
				idList.add(ldHomework.getId());
				File file = new File(uploadDir+ldHomework.getHomeworkFilePath());
				if(file.exists()) {
					file.deleteOnExit();
				}
			}
		}
		if(null != idList && idList.size() > 0) {
			ldHomeworkDao.deleteByIds(idList);
		}
		return ldHomeworkDao.save(homework);
	}
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<LdHomework> queryMyLdHomework(LdHomeworkQuery query) {
		List<LdHomework> homeworkList = ldHomeworkDao.queryList(query);
		for(LdHomework ldHomework : homeworkList) {
			ldHomework.setBestFlagStr(BestFlagEnum.getDescriptionByCode(ldHomework.getBestFlag()).getDescription());
			ldHomework.setCreateDateStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(ldHomework.getCreateDate()));
			ldHomework.setCorrectFlagStr(CorrectFlagEnum.getDescriptionById(ldHomework.getCorrectFlag()).getDescription());
			ldHomework.setLessonName(CourseEnum.getDescriptionById(ldHomework.getLessonId()).getDescription());
			ldHomework.setClassName(ClassEnum.getDescriptionById(ldHomework.getClassId()).getDescription());
		}
		return homeworkList;
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<LdHomeworkFB> queryLdHomeworkFB(LdHomeworkFBQuery query) {
		return ldHomeworkFBDao.queryList(query);
	}
	
	@Transactional
	public Long saveHomeworkFB(LdHomeworkFB ldHomeworkFB) {
		ldHomeworkFB.setCreateDate(new Date());
		String appraiseFlag = ldHomeworkFB.getAppraiseFlag();
	    Map<String, Object> paramMap = new HashMap<String, Object>();
		if(appraiseFlag.equals(AppraiseFlagEnum.GOOD_FEEDBACK.getCode())) {
			paramMap.put("starAddCount", new Integer(1));
		}else {
			paramMap.put("negativeAddCount", new Integer(1));
		}
		paramMap.put("homeworkId", ldHomeworkFB.getHomeworkId());
		ldHomeworkDao.updateAppraiseInfo(paramMap);
		return ldHomeworkFBDao.save(ldHomeworkFB);
		
	}

	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<LdHomework> queryCorrectHomework(LdHomeworkQuery query) {
		List<LdHomework> homeworkList = ldHomeworkDao.queryCorrectHomework(query);
		for(LdHomework ldHomework : homeworkList) {
			ldHomework.setBestFlagStr(BestFlagEnum.getDescriptionByCode(ldHomework.getBestFlag()).getDescription());
			ldHomework.setCreateDateStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(ldHomework.getCreateDate()));
			ldHomework.setCorrectFlagStr(CorrectFlagEnum.getDescriptionById(ldHomework.getCorrectFlag()).getDescription());
			ldHomework.setLessonName(CourseEnum.getDescriptionById(ldHomework.getLessonId()).getDescription());
			ldHomework.setClassName(ClassEnum.getDescriptionById(ldHomework.getClassId()).getDescription());
		}
		return homeworkList;
	}
	
	
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public List<LdHomeworkFB> queryHomeworkAppraise(Long homeworkId) {
		List<LdHomeworkFB> homeworkFBList = ldHomeworkFBDao.queryHomeworkAppraiseList(homeworkId);
		for(LdHomeworkFB ldHomeworkFB : homeworkFBList) {
			ldHomeworkFB.setAppraise(AppraiseFlagEnum.getDescriptionById(ldHomeworkFB.getAppraiseFlag()).getDescription());
			ldHomeworkFB.setLevel(ldHomeworkFB.getLevelFlag());
			ldHomeworkFB.setCreateDateStr(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(ldHomeworkFB.getCreateDate()));
		}
		return homeworkFBList;
	}

}
