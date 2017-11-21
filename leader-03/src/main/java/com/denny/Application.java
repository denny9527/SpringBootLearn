package com.denny;

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, MybatisAutoConfiguration.class})
@Configuration
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, MybatisAutoConfiguration.class})
@ComponentScan("com.denny")
@ImportResource(locations = {"classpath:conf/page-converter-beans.xml"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
