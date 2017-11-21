/**   
 * @Title: UserController.java 
 * @Package com.denny.controller 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年11月5日 上午10:03:59 
 * @version V1.0   
 */
package com.denny.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: UserController
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年11月5日 上午10:03:59
 * 
 */
@Controller
@RequestMapping("/user")
public class UserController {

	private final static Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping("/login_page")
	public String loginPage() {
		return "user/user_login";
	}

	@RequestMapping(value = "/login/success")
	@ResponseBody
	public AjaxResult loginSuccess(HttpServletRequest request) {
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.setResultCode("1");
		ajaxResult.setInfo("用户登录成功!");
		ajaxResult.setUrl("/user/welcome");
		return ajaxResult;
	}

	@RequestMapping(value = "/login/failure")
	@ResponseBody
	public AjaxResult loginFailure(HttpSession session) {
		AuthenticationException authenticationException = (AuthenticationException) session
				.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		logger.info("用户认证失败异常信息:" + authenticationException.getMessage());
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.setResultCode("0");
		ajaxResult.setInfo("用户登录失败,用户名和密码无效!");
		ajaxResult.setUrl("/user/welcome");
		return ajaxResult;
	}

	@RequestMapping("/welcome")
	public String welcome(ModelMap modelMap) {
		modelMap.put("userName", this.getUserName());
		return "/user/welcome";
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
