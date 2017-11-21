/**   
 * @Title: TestDataInitialization.java 
 * @Package com.denny.cmomon.database 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年8月27日 下午8:32:35 
 * @version V1.0   
 */
package com.denny.cmomon.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.PostConstruct;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.denny.test.UserInfoServiceTest;

/**
 * @ClassName: TestDataInitialization
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年8月27日 下午8:32:35
 * 
 */
public class TestDataInitialization {

	private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceTest.class);

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Value("${init.sql.path}")
	private String initSQLPath;

	@PostConstruct
	public void dataInit() {
		try {
			ScriptRunner scriptRunner = new ScriptRunner(
					sqlSessionTemplate.getConfiguration().getEnvironment().getDataSource().getConnection());
			scriptRunner.setAutoCommit(true);//自动提交
			scriptRunner.setFullLineDelimiter(false);
			scriptRunner.setDelimiter(";");//// 每条命令间的分隔符
			scriptRunner.setSendFullScript(false);
			scriptRunner.setStopOnError(false);
			scriptRunner.runScript(new InputStreamReader(new FileInputStream(initSQLPath), "utf-8"));
		} catch (UnsupportedEncodingException e) {
			logger.error("执行测试数据初始化脚本(" + initSQLPath + ")失败:" + e.getMessage());
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			logger.error("执行测试数据初始化脚本(" + initSQLPath + ")失败:" + e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			logger.error("执行测试数据初始化脚本(" + initSQLPath + ")失败:" + e.getMessage());
			e.printStackTrace();
		}

	}
}
