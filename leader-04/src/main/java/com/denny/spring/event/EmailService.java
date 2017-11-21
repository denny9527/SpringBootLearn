/**   
 * @Title: EmailService.java 
 * @Package com.denny.spring.event 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月3日 下午1:25:46 
 * @version V1.0   
 */
package com.denny.spring.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/** 
 * @ClassName: EmailService 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月3日 下午1:25:46 
 *  
 */
@Component
public class EmailService {

	public static final Logger logger = LoggerFactory.getLogger(EmailService.class);
	
	public void sendEmail(String content) {
		logger.info("发送邮件,内容为:"+content);
	}
}
