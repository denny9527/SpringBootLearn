/**   
 * @Title: OrderOperationLogService.java 
 * @Package com.denny.task02.common.service 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年10月7日 下午12:16:38 
 * @version V1.0   
 */
package com.denny.task02.common.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.denny.common.BaseService;
import com.denny.task02.common.domain.OrderOperationLog;

/** 
 * @ClassName: OrderOperationLogService 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年10月7日 下午12:16:38 
 *  
 */
@Service("orderOperationLogService")
public class OrderOperationLogService extends BaseService<OrderOperationLog> {

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public int save(OrderOperationLog t) {
		return super.save(t);
	}
}
