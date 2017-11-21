/**   
 * @Title: OrderService.java 
 * @Package com.denny.task02.common.service 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年10月7日 下午12:14:51 
 * @version V1.0   
 */
package com.denny.task02.common.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.denny.common.BaseService;
import com.denny.task02.common.domain.Order;

/** 
 * @ClassName: OrderService 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年10月7日 下午12:14:51 
 *  
 */
@Service("orderService")
public class OrderService extends BaseService<Order> {

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int save(Order t) {
		return super.save(t);
	}
}
