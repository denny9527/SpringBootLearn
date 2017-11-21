/**   
 * @Title: CustomLogoutSuccessHandler.java 
 * @Package com.denny.security 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年11月4日 上午9:13:35 
 * @version V1.0   
 */
package com.denny.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

/** 
 * @ClassName: CustomLogoutSuccessHandler 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年11月4日 上午9:13:35 
 *  
 */
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

	/* (non-Javadoc) 
	 * <p>Title: onLogoutSuccess</p> 
	 * <p>Description: </p> 
	 * @param request
	 * @param response
	 * @param authentication
	 * @throws IOException
	 * @throws ServletException 
	 * @see org.springframework.security.web.authentication.logout.LogoutSuccessHandler#onLogoutSuccess(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.core.Authentication) 
	 */
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		request.setAttribute("logout", new Boolean(true));
		request.getRequestDispatcher("/rememberMe/user_login").forward(request, response);
	}

}
