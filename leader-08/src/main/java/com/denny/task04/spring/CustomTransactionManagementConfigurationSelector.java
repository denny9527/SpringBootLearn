/**   
 * @Title: CustomTransactionManagementConfigurationSelector.java 
 * @Package com.denny.task04.spring 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年10月7日 下午9:23:52 
 * @version V1.0   
 */
package com.denny.task04.spring;

import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.AdviceModeImportSelector;
import org.springframework.context.annotation.AutoProxyRegistrar;
import org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration;

/**
 * @ClassName: CustomTransactionManagementConfigurationSelector
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年10月7日 下午9:23:52
 * 
 */
public class CustomTransactionManagementConfigurationSelector
		extends AdviceModeImportSelector<CustomTransactionManagement> {

	@Override
	protected String[] selectImports(AdviceMode adviceMode) {
		if (adviceMode == AdviceMode.PROXY)
			return new String[] { AutoProxyRegistrar.class.getName(),
					CustomTransactionManagementConfiguration.class.getName() };
		else return null;
	}

}
