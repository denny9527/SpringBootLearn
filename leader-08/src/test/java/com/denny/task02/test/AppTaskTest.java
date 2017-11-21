/**   
 * @Title: AppTaskTest.java 
 * @Package com.denny.task01.test 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年10月6日 下午12:35:38 
 * @version V1.0   
 */
package com.denny.task02.test;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.denny.task02.config.ApplicationConfig;
import com.denny.task02.common.domain.Order;
import com.denny.task02.common.service.TradeManager;
import com.denny.task02.utils.UUIDUtil;


/** 
 * @ClassName: AppTaskTest 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年10月6日 下午12:35:38 
 *  
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppTaskTest {

	@Autowired
	TradeManager tradeManager;
	
	@Sql(scripts = {
	"classpath:test/trade_init_data.sql" })
	@Test
	public void createOrder() throws Exception {
		Order order = new Order(null, UUIDUtil.generateUUID(), "test-001", UUIDUtil.generateUUID(), "德芙巧克力", 10l,
				new BigDecimal(130.50), new Date(), "18571300391");
		tradeManager.createOrder(order);
	}

}
