/**   
 * @Title: UserController.java 
 * @Package edu.ldcollege.ctrl 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年10月14日 下午4:11:24 
 * @version V1.0   
 */
package edu.ldcollege.ctrl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.denny.utils.ConstantsUtil;
import com.denny.utils.MD5Util;

import edu.ldcollege.domain.User;
import edu.ldcollege.enums.AjaxRespCodeEnum;
import edu.ldcollege.query.UserQuery;
import edu.ldcollege.service.UserService;

/** 
 * @ClassName: UserController 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年10月14日 下午4:11:24 
 *  
 */
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(path = "/user/regist_page", method = RequestMethod.GET)
	public String registPage(HttpSession session, User user) {
		return "user/user-regist";
	}
	
	@RequestMapping(path = "/user/regist", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult regist(HttpSession session, User user) {
		UserQuery userQuery = new UserQuery();
		userQuery.setUserAccount(user.getUserAccount());
		boolean isExisted = userService.verifyUserExisted(userQuery);
		AjaxResult ajaxResult = new AjaxResult();
		if(isExisted) {
			ajaxResult.setResultCode(AjaxRespCodeEnum.FAILURE.getCode());
			ajaxResult.setInfo("用户已存在,请重新输入!");
			return ajaxResult;
		}
		user.setPassword(MD5Util.encrypt(user.getPassword()));
		userService.createUser(user);
		ajaxResult.setResultCode(AjaxRespCodeEnum.SUCCESS.getCode());
		ajaxResult.setInfo("用户注册成功,请登录!");
		ajaxResult.setUrl("index.html");
		return ajaxResult;
	}
	
	@RequestMapping(path = "/user/login", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult login(HttpSession session, UserQuery userQuery) {
		userQuery.setPassword(MD5Util.encrypt(userQuery.getPassword()));
		boolean loginResult = userService.login(userQuery);
		AjaxResult ajaxResult = new AjaxResult();
		if(loginResult) {
			session.setAttribute(ConstantsUtil.SESSION_KEY, userService.querUser(userQuery).get(0));
			ajaxResult.setResultCode(AjaxRespCodeEnum.SUCCESS.getCode());
			ajaxResult.setInfo("用户登录成功!");
			ajaxResult.setUrl("ldhomework/my_homework_page");
			return ajaxResult;
		}else {
			ajaxResult.setResultCode(AjaxRespCodeEnum.FAILURE.getCode());
			ajaxResult.setInfo("用户登录失败,请重新输入!");
		}
		return ajaxResult;
	}
	
	@RequestMapping("user/logout")
	public String logout(HttpSession session) {
		if(session != null) {
			session.removeAttribute(ConstantsUtil.SESSION_KEY);
			session.invalidate();
		}
		return "index";
	}
	
	@RequestMapping(path = {"/", "index"})
	public String index() {
		return "index";
	}

}
