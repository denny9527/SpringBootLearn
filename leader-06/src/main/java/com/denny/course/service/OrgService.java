/**   
 * @Title: OrgService.java 
 * @Package com.denny.course.service 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月17日 上午11:06:18 
 * @version V1.0   
 */
package com.denny.course.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.denny.course.common.BaseService;
import com.denny.course.domain.Org;

/** 
 * @ClassName: OrgService 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月17日 上午11:06:18 
 *  
 */
@Service("orgService")
@Transactional
public class OrgService extends BaseService<Org> {

}
