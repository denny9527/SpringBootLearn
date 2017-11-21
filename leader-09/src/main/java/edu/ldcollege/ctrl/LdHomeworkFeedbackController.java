/**   
 * @Title: LdHomeworkFeedbackController.java 
 * @Package edu.ldcollege.ctrl 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年10月14日 下午4:11:10 
 * @version V1.0   
 */
package edu.ldcollege.ctrl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.denny.utils.ConstantsUtil;

import edu.ldcollege.domain.LdHomework;
import edu.ldcollege.domain.LdHomeworkFB;
import edu.ldcollege.domain.User;
import edu.ldcollege.enums.AjaxRespCodeEnum;
import edu.ldcollege.query.LdHomeworkQuery;
import edu.ldcollege.service.LdHomeworkService;

/** 
 * @ClassName: LdHomeworkFeedbackController 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年10月14日 下午4:11:10 
 *  
 */
@Controller
@RequestMapping("/ldhomeworkFB")
public class LdHomeworkFeedbackController {

	@Autowired
	private LdHomeworkService ldHomeworkService;
	
	@RequestMapping(path = "/homework_list_page")
	public String homeworkListPage(){
		return "homewokFB/correct-ldhomework-list";
	}
	
	@RequestMapping("/correct_homework_list")
	@ResponseBody
	public List<LdHomework> correctHomeworkList(HttpSession session, LdHomeworkQuery ldHomeworkQuery){
		User user = (User) session.getAttribute(ConstantsUtil.SESSION_KEY);
		ldHomeworkQuery.setUserId(user.getId());
		ldHomeworkQuery.setExcludeUserId(user.getId());
		return this.ldHomeworkService.queryCorrectHomework(ldHomeworkQuery);
	}
	
	@RequestMapping(path = "/correct_page", method = RequestMethod.GET)
	public String correctPage(Model model, String homeworkId, String userId){
		model.addAttribute("homeworkId", homeworkId);
		model.addAttribute("userId", userId);
		return "homewokFB/ldhomework-fb";
	}

	@RequestMapping(path = "/correct", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult correct(HttpSession session, LdHomeworkFB ldHomeworkFB){
		AjaxResult ajaxResult = new AjaxResult();
		try {
			User user = (User) session.getAttribute(ConstantsUtil.SESSION_KEY);
			ldHomeworkFB.setCorrectUserId(user.getId());
			ldHomeworkService.saveHomeworkFB(ldHomeworkFB);
			ajaxResult.setResultCode(AjaxRespCodeEnum.SUCCESS.getCode());
			ajaxResult.setInfo("作业批改信息保存成功!");
			ajaxResult.setUrl("ldhomeworkFB/homework_list_page");
		} catch (Exception e) {
			ajaxResult.setResultCode(AjaxRespCodeEnum.FAILURE.getCode());
			ajaxResult.setInfo("作业批改信息保存失败,请重新执行!");
		}
		return ajaxResult;
	}
	
	@RequestMapping(path = "/appraise_list_page", method = RequestMethod.GET)
	public String appraiseListPage(Model model, Long homeworkId){
		model.addAttribute("homeworkId", homeworkId);
		return "homewokFB/ldhomework-appraise-list";
	}

	@RequestMapping(path = "/appraise_list", method = RequestMethod.GET)
	@ResponseBody
	public List<LdHomeworkFB> appraiseList(HttpSession session, Long homeworkId){
		return ldHomeworkService.queryHomeworkAppraise(homeworkId);
	}

}
