/**   
 * @Title: SecurityDemoController.java 
 * @Package com.denny.controller 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年10月27日 下午4:40:39 
 * @version V1.0   
 */
package com.denny.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName: SecurityDemoController
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年10月27日 下午4:40:39
 * 
 */
@Controller
public class SecurityDemoController {

	@RequestMapping("/admin/index")
	public String adminIndex() {
		return "admin_index";
	}

//	@RequestMapping("/auth/failure")
//	public String authFailure() {
//		return "error";
//	}

	@RequestMapping("/manager/index")
	public String managerIndex() {
		return "success";
	}

	@RequestMapping("/manager/createuser")
	public String createUser() {
		return "success";
	}

	@RequestMapping("/rememberMe/user_login")
	public String userLogin(ModelMap modelMap, HttpServletRequest reqeust) {
		SecurityContext securityContext = (SecurityContext) reqeust.getSession()
				.getAttribute("SPRING_SECURITY_CONTEXT");
		if (securityContext != null && !StringUtils
				.isEmpty(((UserDetails) (securityContext.getAuthentication().getPrincipal())).getUsername())) {
			return "forward:/rememberMe/welcome";
		}
		Boolean logout = (Boolean) reqeust.getAttribute("logout");
		if (!StringUtils.isEmpty(logout)) {
			modelMap.put("logout", logout.booleanValue());
		}
		return "rememberMe/user_login";
	}

	@RequestMapping({ "/", "/rememberMe/welcome" })
	public String welcome(ModelMap modelMap) {
		modelMap.put("userName", this.getUserName());
		return "rememberMe/welcome";
	}

	@RequestMapping("/rememberMe/auth_failure")
	public String authFailure() {
		return "rememberMe/auth_failure";
	}

	private String getUserName() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
}
