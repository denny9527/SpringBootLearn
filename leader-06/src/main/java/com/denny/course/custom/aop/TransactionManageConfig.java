/**   
 * @Title: TransactionManageConfig.java 
 * @Package com.denny.course.jdk.aop 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月18日 上午10:53:38 
 * @version V1.0   
 */
package com.denny.course.custom.aop;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import com.denny.common.IBaseService;
import com.denny.course.spring.aop.ConnectionManager;
import com.denny.course.spring.aop.TransactionManager;

/**
 * @ClassName: TransactionManageConfig
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年9月18日 上午10:53:38
 * 
 */
@Component("transactionManageConfig")
public class TransactionManageConfig {

	private final static Logger logger = LoggerFactory.getLogger(TransactionManageConfig.class);

	@Autowired
	private ConnectionManager connectionManager;

	@Autowired
	private TransactionManager transactionManager;

	private List<Advice> adviceList = new LinkedList<Advice>();

	@PostConstruct
	public void initAdivce() {
		adviceList.add(new BeforeAdvice() {
			@Override
			public void execute(Object target, Method method) throws Throwable {
				String methodName = method.getName();
				if (isTransactionManage(methodName)) {
					logger.info("调用目标对象:" + target + " 方法:" + methodName + "开启事务");
					transactionManager.beginTransaction();
				} else {
					logger.info("调用目标对象:" + target + " 方法:" + methodName + "不开启事务");
				}
			}
		});

		adviceList.add(new AfterReturningAdvice() {
			@Override
			public void execute(Object target, Method method) throws Throwable {
				String methodName = method.getName();
				if (isTransactionManage(methodName)) {
					transactionManager.commitTransaction();
					logger.info("调用目标对象:" + target + " 方法:" + methodName + "提交事务");
				}
				connectionManager.closeConnection();
			}
		});
		
		adviceList.add(new AfterThrowingAdvice() {
			@Override
			public void execute(Object target, Method method, Throwable ex) throws Throwable {
				String methodName = method.getName();
				boolean isTransaction = isTransactionManage(methodName);
				if (ex instanceof RuntimeException || ex.getCause() instanceof RuntimeException) {
					if (isTransaction) {
						transactionManager.rollbackTransaction();
						logger.info("调用目标对象:" + target + " 方法:" + methodName + "回滚事务");
					}
				} else {
					if (isTransaction) {
						transactionManager.commitTransaction();
						logger.info("调用目标对象:" + target + " 方法:" + methodName + "提交事务");
					}
				}
				connectionManager.closeConnection();
			}

			@Override
			public void execute(Object target, Method method) throws Throwable {
			}
		});
	}

	private boolean isTransactionManage(String methodName) {
		return methodName.startsWith("create") || methodName.startsWith("update")
				|| methodName.startsWith("save")
				|| methodName.startsWith("delete");
	}

	/**
	 * @return adviceList
	 */
	public List<Advice> getAdviceList() {
		return adviceList;
	}

	/**
	 * @param adviceList
	 *            the adviceList to set
	 */
	public void setAdviceList(List<Advice> adviceList) {
		this.adviceList = adviceList;
	}

}
