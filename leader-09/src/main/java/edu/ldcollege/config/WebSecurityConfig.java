/**   
 * @Title: WebSecurityConfig.java 
 * @Package edu.ldcollege.config 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年10月18日 下午4:51:42 
 * @version V1.0   
 */
package edu.ldcollege.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.denny.utils.ConstantsUtil;

/**
 * @ClassName: WebSecurityConfig
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年10月18日 下午4:51:42
 * 
 */
@Configuration
public class WebSecurityConfig extends WebMvcConfigurerAdapter {

	@Bean
	public SecurityInterceptor getSecurityInterceptor() {
		return new SecurityInterceptor();
	}

	public void addInterceptors(InterceptorRegistry registry) {
		InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());

		// 排除配置
		addInterceptor.excludePathPatterns("/error");
		addInterceptor.excludePathPatterns("/user/login**");
		addInterceptor.excludePathPatterns("/user/regist**");
		addInterceptor.excludePathPatterns("/index");

		// 拦截配置
		addInterceptor.addPathPatterns("/**");
	}

	private class SecurityInterceptor extends HandlerInterceptorAdapter {

		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {
			HttpSession session = request.getSession();
			if (session.getAttribute(ConstantsUtil.SESSION_KEY) != null)
				return true;

			String url = "/index";
			response.sendRedirect(url);
			return false;
		}
	}

}
