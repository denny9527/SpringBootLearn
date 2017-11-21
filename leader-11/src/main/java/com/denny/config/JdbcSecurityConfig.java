/**   
 * @Title: JdbcSecurityConfig.java 
 * @Package com.denny.config 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年10月28日 下午1:37:18 
 * @version V1.0   
 */
package com.denny.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.denny.security.CustomLogoutSuccessHandler;

/**
 * @ClassName: JdbcSecurityConfig
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年10月28日 下午1:37:18
 * 
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class JdbcSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// homework-1
		// http.authorizeRequests().antMatchers("/manager/**").hasAnyRole("manager").antMatchers("/manager/createuser")
		// .hasAuthority("op_createuser").and().formLogin().and().httpBasic();

		// homework-4
		// http.authorizeRequests().antMatchers("/",
		// "/rememberMe/**").access("hasRole('manager')").and().formLogin()
		// .loginPage("/rememberMe/user_login").permitAll().loginProcessingUrl("/login")
		// .successForwardUrl("/rememberMe/welcome").failureUrl("/rememberMe/auth_failure").and().logout()
		// // .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
		// // .logoutSuccessUrl("/rememberMe/user_login")
		// .logoutUrl("/logout").logoutSuccessHandler(getCustomLogoutSuccessHandler()).deleteCookies("JSESSIONID")
		// .invalidateHttpSession(true).and().rememberMe().key("custom-key")
		// .tokenRepository(getPersistentTokenRepository()).tokenValiditySeconds(604800).and().exceptionHandling()
		// .accessDeniedPage("/rememberMe/access_denied").and().csrf().and().headers().xssProtection().block(true);

		http.authorizeRequests().antMatchers("/user/**").access("hasRole('user')").and().formLogin()
				.loginPage("/user/login_page").permitAll().loginProcessingUrl("/login")
				.successForwardUrl("/user/login/success").failureUrl("/user/login/failure").and().csrf();
				//.csrfTokenRepository(getCsrfTokenRepository());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("**/js/**", "**/css/**", "/**/*.js", "/**/*.css", "/**/favicon.ico", "/static/**");
	}

	@Bean
	public UserDetailsManager getUserDetailManager() {
		JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager();
		userDetailsManager.setDataSource(dataSource);
		userDetailsManager.setRolePrefix("ROLE_");
		userDetailsManager.setEnableGroups(true);
		userDetailsManager.setEnableAuthorities(true);
		return userDetailsManager;
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(getUserDetailManager());
	}

	@Bean
	public PersistentTokenRepository getPersistentTokenRepository() {
		JdbcTokenRepositoryImpl tokenRepositoryImpl = new JdbcTokenRepositoryImpl();
		tokenRepositoryImpl.setDataSource(dataSource);
		return tokenRepositoryImpl;

	}

	@Bean
	public LogoutSuccessHandler getCustomLogoutSuccessHandler() {
		CustomLogoutSuccessHandler customLogoutSuccessHandler = new CustomLogoutSuccessHandler();
		return customLogoutSuccessHandler;

	}

	@Bean
	public CsrfTokenRepository getCsrfTokenRepository() {
		CsrfTokenRepository csrfTokenRepository = new CookieCsrfTokenRepository();
		return csrfTokenRepository;
	}
}
