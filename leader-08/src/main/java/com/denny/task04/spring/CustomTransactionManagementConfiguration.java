/**   
 * @Title: CustomTransactionManagementConfiguration.java 
 * @Package com.denny.task04.spring 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年10月7日 下午3:14:34 
 * @version V1.0   
 */
package com.denny.task04.spring;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.AbstractTransactionManagementConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.config.TransactionManagementConfigUtils;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.NoRollbackRuleAttribute;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionAttribute;
import org.springframework.transaction.interceptor.TransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionInterceptor;
import org.springframework.transaction.annotation.Isolation;

/**
 * @ClassName: CustomTransactionManagementConfiguration
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年10月7日 下午3:14:34
 * 
 */
@Configuration
public class CustomTransactionManagementConfiguration extends AbstractTransactionManagementConfiguration {

	@Bean(name = TransactionManagementConfigUtils.TRANSACTION_ADVISOR_BEAN_NAME)
	@Role(BeanDefinition.ROLE_INFRASTRUCTURE)
	public AspectJExpressionPointcutAdvisor transactionAdvisor() {
		AspectJExpressionPointcutAdvisor advisor = new AspectJExpressionPointcutAdvisor();
		if (this.enableTx == null) {
			throw new IllegalArgumentException("@CustomEnableTransactionManagement is to be imported ");
		}
		advisor.setExpression(this.enableTx.getString("expression"));
		advisor.setAdvice(transactionInterceptor());
		return advisor;
	}

	@Bean
	@Role(BeanDefinition.ROLE_INFRASTRUCTURE)
	public TransactionAttributeSource transactionAttributeSource() {
		if (this.enableTx == null) {
			throw new IllegalArgumentException("@CustomEnableTransactionManagement is to be imported ");
		}
		NameMatchTransactionAttributeSource nameMatchTransactionAttributeSource = new NameMatchTransactionAttributeSource();
		Map<String, TransactionAttribute> nameMap = new LinkedHashMap<String, TransactionAttribute>();
		AnnotationAttributes[] annotationAttributeArray = this.enableTx.getAnnotationArray("transactionAttributes");
		for (AnnotationAttributes annotationAttributes : annotationAttributeArray) {
			RuleBasedTransactionAttribute ruleBasedTransactionAttribute = new RuleBasedTransactionAttribute();
			ruleBasedTransactionAttribute
					.setIsolationLevel(((Isolation) annotationAttributes.getEnum("isolation")).value());
			ruleBasedTransactionAttribute
					.setPropagationBehavior(((Propagation) annotationAttributes.getEnum("propagation")).value());
			ruleBasedTransactionAttribute.setReadOnly(annotationAttributes.getBoolean("readOnly"));
			List<RollbackRuleAttribute> rollbackRules = new ArrayList<RollbackRuleAttribute>();
			Class<?>[] rollbackArray = annotationAttributes.getClassArray("rollbackFor");
			Class<?>[] noRollbackArray = annotationAttributes.getClassArray("noRollbackFor");
			if (null != rollbackArray && rollbackArray.length > 0) {
				for (Class<?> rollbackClass : rollbackArray) {
					RollbackRuleAttribute rollbackRuleAttribute = new RollbackRuleAttribute(rollbackClass);
					rollbackRules.add(rollbackRuleAttribute);
				}
			}
			if (null != noRollbackArray && noRollbackArray.length > 0) {
				for (Class<?> noRollbackClass : noRollbackArray) {
					NoRollbackRuleAttribute noRollbackRuleAttribute = new NoRollbackRuleAttribute(noRollbackClass);
					rollbackRules.add(noRollbackRuleAttribute);
				}
			}
			ruleBasedTransactionAttribute.setRollbackRules(rollbackRules);
			nameMap.put(annotationAttributes.getString("methodName"), ruleBasedTransactionAttribute);
		}
		nameMatchTransactionAttributeSource.setNameMap(nameMap);
		return nameMatchTransactionAttributeSource;
	}

	@Bean
	@Role(BeanDefinition.ROLE_INFRASTRUCTURE)
	public TransactionInterceptor transactionInterceptor() {
		TransactionInterceptor interceptor = new TransactionInterceptor();
		interceptor.setTransactionAttributeSource(transactionAttributeSource());
		if (this.txManager != null) {
			interceptor.setTransactionManager(this.txManager);
		}
		return interceptor;
	}

	@Override
	public void setImportMetadata(AnnotationMetadata importMetadata) {
		this.enableTx = AnnotationAttributes
				.fromMap(importMetadata.getAnnotationAttributes(CustomTransactionManagement.class.getName(), false));
		if (this.enableTx == null) {
			throw new IllegalArgumentException("@CustomEnableTransactionManagement is not present on importing class "
					+ importMetadata.getClassName());
		}
	}

}
