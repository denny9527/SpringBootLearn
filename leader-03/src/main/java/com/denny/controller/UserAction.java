/**   
 * @Title: UserAction.java 
 * @Package com.denny.controller 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年8月25日 下午1:23:26 
 * @version V1.0   
 */
package com.denny.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.assertj.core.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.denny.user.common.bean.UserInfo;
import com.denny.user.common.query.UserInfoQuery;
import com.denny.user.common.service.IUserInfoService;
import com.denny.user.common.service.UserInfoServiceImpl;
import com.denny.utils.MD5Util;
import com.denny.utils.UUIDUtil;

/** 
 * @ClassName: UserAction 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年8月25日 下午1:23:26 
 *  
 */
//@Controller("userAction")
@RestController("userAction")
@RequestMapping("/user_manage")
public class UserAction {
	
	@Autowired(required = true) //默认以类型匹配
	//注：有多个实现使用加上 @Qualifier("userInfoService") 以名称匹配;或者使用@Resource(name = "userInfoService")
	private IUserInfoService userInfoService;

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */
	public UserAction() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(path = "/create_user", method = RequestMethod.POST)
	public Map<String, String> createUser(ModelMap modleMap, @RequestBody UserInfo userInfo){
		Map<String, String> resultMap = new HashMap<String, String>();
		userInfo.setRegdate(new Date());
		userInfo.setUserId(UUIDUtil.generateUUID());
		userInfo.setPassword(MD5Util.encrypt(userInfo.getPassword()));
		userInfo.setEnabled("1");
		userInfoService.save(userInfo);
		resultMap.put("reulst", "用户注册成功");
		return resultMap;
	}

	@RequestMapping(path = "/delete_user/{id}", method = RequestMethod.DELETE)
	public Map<String, String> deleteUser(ModelMap modleMap, @PathVariable Long id){
		Map<String, String> resultMap = new HashMap<String, String>();
		userInfoService.deleteById(id);
		resultMap.put("result", "用户删除成功");
		return resultMap;
	}
	
	@RequestMapping(path = "/disable_user/{id}", method = RequestMethod.GET)
	public Map<String, String> disableUser(ModelMap modleMap, @PathVariable Long id){
		Map<String, String> resultMap = new HashMap<String, String>();
		UserInfo userInfo = userInfoService.getById(id);
		userInfo.setEnabled("0");
		userInfoService.update(userInfo);
		resultMap.put("result", "用户注销成功");
		return resultMap;
	}
	
	@RequestMapping(path = "/query_users", method = RequestMethod.POST)
	public List<UserInfo> queryUsers(ModelMap modleMap, @RequestBody UserInfoQuery userQuery){
		List<UserInfo> userList = userInfoService.queryList(userQuery);
		return userList;
	}
	
	@RequestMapping(path = "/paging_query_users", method = RequestMethod.POST)
	public List<UserInfo> pagingQueryUser(ModelMap modleMap, @RequestBody UserInfoQuery userQuery){
		List<UserInfo> userList = userInfoService.queryWithPage(userQuery);
		return userList;
	}
	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public Map<String, String> login(HttpSession session, ModelMap modleMap, @RequestBody UserInfo userInfo){
		Map<String, String> resultMap = new HashMap<String, String>();
		String userName = userInfo.getUserName();
		String password = userInfo.getPassword();
		if(Strings.isNullOrEmpty(userName) || Strings.isNullOrEmpty(password)) {
			resultMap.put("result", "请输入用户名称和密码");
		}
		UserInfoQuery query = new UserInfoQuery();
		query.setUserName(userInfo.getUserName());
		query.setPassword(MD5Util.encrypt(userInfo.getPassword()));
		query.setEnabled("1");
		Long count = userInfoService.queryCount(query);
		if(count <= 0) {
			resultMap.put("result", "用户信息不存在");
		}else {
			resultMap.put("result", "用户登录成功");
			session.setAttribute("userName", userName);
		}
		return resultMap;
	}
	
	
}
