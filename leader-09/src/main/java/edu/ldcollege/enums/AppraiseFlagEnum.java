/**   
 * @Title: AppraiseFlagEnum.java 
 * @Package edu.ldcollege.enums 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年10月16日 下午1:15:34 
 * @version V1.0   
 */
package edu.ldcollege.enums;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName: AppraiseFlagEnum
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年10月16日 下午1:15:34
 * 
 */
public enum AppraiseFlagEnum {

	GOOD_FEEDBACK("1", "点赞"), NEGATIVE_FEEDBACK("0", "差评");

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
	private AppraiseFlagEnum(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public static AppraiseFlagEnum getDescriptionById(String code) {
		for (AppraiseFlagEnum type : values()) {
			if (type.getCode().equals(code))
				return type;
		}
		return null;
	}

	public static Map<String, String> toMap() {
		Map<String, String> enumDataMap = new LinkedHashMap<String, String>();
		for (AppraiseFlagEnum type : values()) {
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
	 * @param code
	 *            the code to set
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
