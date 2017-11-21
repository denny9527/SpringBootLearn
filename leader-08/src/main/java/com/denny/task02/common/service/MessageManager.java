/**   
 * @Title: MessageService.java 
 * @Package com.denny.task02.common.service 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年10月7日 下午12:17:39 
 * @version V1.0   
 */
package com.denny.task02.common.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.denny.task01.common.service.CompositeService;
import com.denny.common.IBaseService;
import com.denny.task02.common.domain.SMSlog;

/** 
 * @ClassName: MessageService 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年10月7日 下午12:17:39 
 *  
 */
@Service("messageManager")
public class MessageManager {

	private final static Logger logger = LoggerFactory.getLogger(MessageManager.class);
	
	@Autowired
	private IBaseService<SMSlog> smsLogService;
	
	@Autowired
	private TaskExecutor taskExecutor;
	
	@Transactional(propagation = Propagation.NESTED)
	public void sendSMS(SMSlog smsLog) {
		smsLogService.save(smsLog);
		taskExecutor.execute(() -> {logger.info("异步发送短信,短信内容为:"+smsLog.getSmsContent());});
	}
	
}
