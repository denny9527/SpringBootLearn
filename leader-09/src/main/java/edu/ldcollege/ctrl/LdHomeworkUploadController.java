/**   
 * @Title: LdHomeworkUploadController.java 
 * @Package edu.ldcollege.ctrl 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年10月14日 下午4:10:56 
 * @version V1.0   
 */
package edu.ldcollege.ctrl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.denny.utils.ConstantsUtil;

import edu.ldcollege.domain.LdHomework;
import edu.ldcollege.domain.User;
import edu.ldcollege.enums.AjaxRespCodeEnum;
import edu.ldcollege.query.LdHomeworkQuery;
import edu.ldcollege.service.LdHomeworkService;

/**
 * @ClassName: LdHomeworkUploadController
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年10月14日 下午4:10:56
 * 
 */
@Controller
@RequestMapping("/ldhomework")
public class LdHomeworkUploadController {

	@Autowired
	private LdHomeworkService ldHomeworkService;

	@Value("${upload.dir}")
	private String uploadDir;
	
	@RequestMapping("/my_homework_page")
	public String myHomeworkPage() {
		return "myHomework/ldhomework-list";
	}
	
	@RequestMapping(path = "/upload_page", method = RequestMethod.GET)
	public String uploadHomeworkPage() {
		return "myHomework/ldhomework-upload";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public List<LdHomework> homeworkList(HttpSession session, LdHomeworkQuery ldHomeworkQuery) {
		User user = (User) session.getAttribute(ConstantsUtil.SESSION_KEY);
		ldHomeworkQuery.setUserId(user.getId());
		return this.ldHomeworkService.queryMyLdHomework(ldHomeworkQuery);
	}
	
	@RequestMapping(path = "/upload")
	@ResponseBody
	public AjaxResult uploadHomework(HttpServletRequest request,
			@RequestParam("homeworkFile") MultipartFile homeworkFile) {
		AjaxResult ajaxResult = new AjaxResult();
		try {
			DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			String filename = homeworkFile.getOriginalFilename();
			String newFileName = df.format(new Date()) + "-"
					+ UUID.randomUUID().toString().replaceAll("-", "").replaceAll("\\d", "");
			String ext = filename.substring(filename.lastIndexOf(".") + 1, filename.length());
			String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
			File file = new File(uploadDir + currentDate);
			if (!file.exists()) file.mkdirs();
			String filepPath = currentDate + "/" + newFileName + "." + ext;
			homeworkFile.transferTo(new File(uploadDir + filepPath));
			ajaxResult.setResultCode(AjaxRespCodeEnum.SUCCESS.getCode());
			Map<String, String> resultMap = new HashMap<String, String>();
			resultMap.put("filePath", filepPath);
			resultMap.put("fileName", filename);
			ajaxResult.setInfo("作业上传成功!");
			ajaxResult.setResultMap(resultMap);
		} catch (Exception e) {
			ajaxResult.setResultCode(AjaxRespCodeEnum.FAILURE.getCode());
			ajaxResult.setInfo("作业上传失败,请重新执行!");
		}
		return ajaxResult;
	}

	@RequestMapping("/save")
	@ResponseBody
	public AjaxResult saveHomework(HttpSession session, LdHomework ldHomework) {
		AjaxResult ajaxResult = new AjaxResult();
		try {
			User user = (User) session.getAttribute(ConstantsUtil.SESSION_KEY);
			ldHomework.setUserId(user.getId());
			ldHomework.setCreateDate(new Date());
			this.ldHomeworkService.saveHomework(ldHomework);
			ajaxResult.setResultCode(AjaxRespCodeEnum.SUCCESS.getCode());
			ajaxResult.setInfo("作业上传成功!");
			ajaxResult.setUrl("ldhomework//my_homework_page");
		} catch (Exception e) {
			ajaxResult.setResultCode(AjaxRespCodeEnum.FAILURE.getCode());
			ajaxResult.setInfo("作业上传失败,请重新执行!");
		}
		return ajaxResult;
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void downloadHomework(HttpServletResponse response, String filePath, String fileName) {
		File file = new File(this.uploadDir + "/" + filePath);
		if (file.exists()) {
			response.setContentType("application/force-download");
			response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
			byte[] buffer = new byte[1024];
			FileInputStream fileInputStream = null; // 文件输入流
			BufferedInputStream bufferedInputStream = null;
			OutputStream outputStream = null; // 输出流
			try {
				outputStream = response.getOutputStream();
				fileInputStream = new FileInputStream(file);
				bufferedInputStream = new BufferedInputStream(fileInputStream);
				int byteNum = bufferedInputStream.read(buffer);
				while (byteNum != -1) {
					outputStream.write(buffer);
					byteNum = bufferedInputStream.read(buffer);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(fileInputStream != null) fileInputStream.close();
					if(bufferedInputStream != null) bufferedInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
