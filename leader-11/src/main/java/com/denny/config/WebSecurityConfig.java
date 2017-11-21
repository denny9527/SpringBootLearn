/**   
 * @Title: WebSecurityConfig.java 
 * @Package com.denny.config 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年10月27日 下午4:24:22 
 * @version V1.0   
 */
package com.denny.config;

import java.util.Properties;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @ClassName: WebSecurityConfig
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年10月27日 下午4:24:22
 * 
 */
//@Configuration
//@Order(101)

//@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.sessionManagement().sessionFixation().changeSessionId();
	}
}	

	// homework-4
//	 http.authorizeRequests().antMatchers("/",
//	 "/rememberMe/**").access("hasRole('manager')").and().formLogin()
//	 .loginPage("/rememberMe/user_login").permitAll().loginProcessingUrl("/login")
//	 .successForwardUrl("/rememberMe/welcome").failureUrl("/rememberMe/auth_failure").and().logout()
//	 //.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
//	 // .logoutSuccessUrl("/rememberMe/user_login")
//	 .logoutUrl("/logout")
//	 .logoutSuccessHandler(getCustomLogoutSuccessHandler()).deleteCookies("JSESSIONID")
//	 .invalidateHttpSession(true).and().rememberMe().key("custom-key")
//	 .tokenRepository(getPersistentTokenRepository()).and().exceptionHandling()
//	 .accessDeniedPage("/rememberMe/access_denied")
//	 .and().csrf().and().headers().xssProtection().block(true);
//	 //.and().contentSecurityPolicy("script-src 'self'
//	 https://trustedscripts.example.com; object-src
//	 https://trustedplugins.example.com; report-uri /csp-report-endpoint/");

//	http.authorizeRequests().antMatchers("/user/**").access("hasRole('user')").and().formLogin()
//			.loginPage("/user/login_page").permitAll().loginProcessingUrl("/login")
//			.successForwardUrl("/user/login/success").failureUrl("/user/login/failure").and().csrf();
//	}
//
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("**/js/**", "**/css/**", "**/images/**", "**/**/favicon.ico");
//
//	}
//
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		//auth.userDetailsService(inMemoryUserDetailsManager());
//		Properties users = new Properties();
//		users.put("zhangkui", "123456,ROLE_ADMIN,enabled");
//		auth.userDetailsService(new InMemoryUserDetailsManager(users));
//	}
//}
