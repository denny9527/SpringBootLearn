package edu.ldcollege;

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@SpringBootApplication
@Configuration
@EnableAutoConfiguration(exclude = {MybatisAutoConfiguration.class})
//@ComponentScan({"com.denny", "edu.ldcollege"})
@ComponentScan(basePackages = {"com.denny", "edu.ldcollege"})
@ImportResource(locations = {"classpath:conf/page-converter-beans.xml"})
@EnableTransactionManagement
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
