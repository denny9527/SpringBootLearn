/**   
 * @Title: ClassEnum.java 
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
 * @ClassName: ClassEnum 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年10月15日 上午11:43:35 
 *  
 */
public enum ClassEnum {
	
	CLASS_100(200l, "黄埔三期");
	
	private Long id;
	
	private String description;

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p> 
	 * @param id
	 * @param description 
	 */
	private ClassEnum(Long id, String description) {
		this.id = id;
		this.description = description;
	}

	public static ClassEnum getDescriptionById(Long id) {
		for (ClassEnum type : values()) {
			if (type.getId().longValue() == id.longValue())
				return type;
		}
		return null;
	}

	public static Map<Long, String> toMap() {
	        Map<Long, String> enumDataMap = new LinkedHashMap<Long, String>();
	        for (ClassEnum type : values()) {
	            enumDataMap.put(type.getId(), type.getDescription());
	        }
	        return enumDataMap;
	    }

	/** 
	 * @return id 
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/** 
	 * @return description 
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
