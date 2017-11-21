/**   
 * @Title: SessionTestController.java 
 * @Package com.denny.ctrl 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年10月19日 下午9:25:15 
 * @version V1.0   
 */
package com.denny.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.denny.domain.UserInfo;
import com.denny.enums.AjaxRespCodeEnum;
import com.denny.utils.ConstantsUtil;

/**
 * @ClassName: SessionTestController
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年10月19日 下午9:25:15
 * 
 */
@Controller
public class SessionTestController {

	@RequestMapping(path = {"/","/distSession"})
	public ModelAndView distSession(HttpSession session) {
		ModelAndView modleAndView = new ModelAndView();
		UserInfo userInfo = (UserInfo) session.getAttribute(ConstantsUtil.SESSION_KEY);
		if (userInfo == null) {
			modleAndView.setViewName("save_userInfo");
		} else {
			modleAndView.setViewName("list_myInfo");
		}
		return modleAndView;
	}
	
	@RequestMapping(path = "/save_userInfo", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult saveUserInfo(HttpSession session, @Valid UserInfo userInfo, BindingResult bindingResult) {
		AjaxResult ajaxResult = new AjaxResult();
		if(bindingResult.hasErrors()) {
			Map<String, String> errorInfoMap = new HashMap<String, String>();
			bindingResult.getFieldErrors().stream().forEach(o -> {
				errorInfoMap.put(o.getField(), o.getDefaultMessage());
			});
			ajaxResult.setResultCode(AjaxRespCodeEnum.FAILURE.getCode());
			ajaxResult.setResultMap(errorInfoMap);
		}else {
			session.removeAttribute(ConstantsUtil.SESSION_KEY);
			session.setAttribute(ConstantsUtil.SESSION_KEY, userInfo);
			ajaxResult.setResultCode(AjaxRespCodeEnum.SUCCESS.getCode());
			ajaxResult.setUrl("/distSession/listMyInfo");
		}
		return ajaxResult;
	}
	
	@RequestMapping(path = "/distSession/listMyInfo")
	public String listMyInfo() {
		return "list_myInfo";
	}

}
