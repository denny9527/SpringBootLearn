/**   
 * @Title: CourseService.java 
 * @Package com.denny.course.service 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月9日 上午10:09:37 
 * @version V1.0   
 */
package com.denny.course.service;

import java.io.Serializable;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.denny.common.dao.IBaseDao;
import com.denny.common.service.BaseServiceImpl;
import com.denny.common.service.IBaseService;
import com.denny.course.domain.Course;
import com.denny.course.query.CourseQuery;

/**
 * @ClassName: CourseService
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年9月9日 上午10:09:37
 * 
 */
@Service("courseService")
public class CourseService extends BaseServiceImpl<Course, Long, CourseQuery>
		implements IBaseService<Course, Long, CourseQuery>, Ordered, ApplicationContextAware, Serializable {
	
	private ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public int getOrder() {
		return Integer.MAX_VALUE;
	}

}
