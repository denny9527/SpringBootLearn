/**   
 * @Title: UserCareService.java 
 * @Package com.denny.jdk.event 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月2日 下午8:28:08 
 * @version V1.0   
 */
package com.denny.spring.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @ClassName: UserCareService
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年9月2日 下午8:28:08
 * 
 */
@Component
public class UserCareService {

	private static final Logger logger = LoggerFactory.getLogger(UserCareService.class);

	@Autowired
	private EmailService emailService;

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	public UserCareService() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @Title: sendEmailForVIPUser @Description: TODO @param @param userName @return
	 * void @throws
	 */
	@EventListener(classes = { VIPUserCreationEvent.class })
	@Order(50)
	public void sendEmailForVIPUser(VIPUserCreationEvent vipUserCreationEvent) {
		logger.info("当前执行线程为:" + Thread.currentThread().getName());
		StringBuffer content = new StringBuffer();
		content.append("尊敬的" + vipUserCreationEvent.getUserName() + "先生/女士:恭喜你成为我们的VIP用户,我们将为你提供更优质的服务!");
		this.emailService.sendEmail(content.toString());
	}

	@EventListener(classes = { VIPUserCreationEvent.class })
	@Order(1)
	public void sendVIPUserInfoToCustCenter(VIPUserCreationEvent vipUserCreationEvent) throws InterruptedException {
		logger.info("当前执行线程为:" + Thread.currentThread().getName());
		StringBuffer content = new StringBuffer();
		content.append("新增VIP用户,向客服中心发送通知:");
		content.append("用户:" + vipUserCreationEvent.getUserName() + "已正式成为VIP用户,请安排客服人员提供专属服务。并向客户赠送VIP大礼包");
		logger.info(content.toString());
		logger.info("向客服中心发送通知线程休眠5秒!");
		Thread.sleep(5000);
	}

}
