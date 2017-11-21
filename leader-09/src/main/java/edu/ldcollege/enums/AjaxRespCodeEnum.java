/**   
 * @Title: CourseEnum.java 
 * @Package edu.ldcollege.enums 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年10月15日 上午11:43:35 
 * @version V1.0   
 */
package edu.ldcollege.enums;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName: CourseEnum
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年10月15日 上午11:43:35
 * 
 */
public enum AjaxRespCodeEnum {

	SUCCESS("1", "成功"), FAILURE("0", "失败");

	private String code;

	private String description;

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param code
	 * @param description
	 */
	private AjaxRespCodeEnum(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public static AjaxRespCodeEnum getDescriptionByCode(String code) {
		for (AjaxRespCodeEnum type : values()) {
			if (type.getCode().equals(code))
				return type;
		}
		return null;
	}

	public static Map<String, String> toMap() {
		Map<String, String> enumDataMap = new LinkedHashMap<String, String>();
		for (AjaxRespCodeEnum type : values()) {
			enumDataMap.put(type.getCode(), type.getDescription());
		}
		return enumDataMap;
	}

	/** 
	 * @return code 
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
