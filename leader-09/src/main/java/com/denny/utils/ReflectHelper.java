/**   
 * @Title: ReflectHelper.java 
 * @Package com.denny.mybatis.utils 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年8月24日 下午6:03:57 
 * @version V1.0   
 */
package com.denny.utils;

import java.lang.reflect.Field;

import org.springframework.util.ReflectionUtils;

/**
 * @ClassName: ReflectHelper
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年8月24日 下午6:03:57
 * 
 */
public final class ReflectHelper {

	public static Field getFieldByFieldName(Object obj, String fieldName) {
		return 	ReflectionUtils.findField(obj.getClass(), fieldName);
	}

	public static Object getValueByFieldName(Object obj, String fieldName)
			throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		Field field = getFieldByFieldName(obj, fieldName);
		//ReflectionUtils.makeAccessible(field);
		//Object value = ReflectionUtils.getField(field, obj);
		Object value = null;
		if (field != null) {
			if (field.isAccessible()) {
				value = field.get(obj);
			} else {
				field.setAccessible(true);
				value = field.get(obj);
				field.setAccessible(false);
			}
		}
		return value;
	}

	public static void setValueByFieldName(Object obj, String fieldName, Object value) throws Exception {
		Field field = getFieldByFieldName(obj, fieldName);
//		ReflectionUtils.makeAccessible(field);
//		ReflectionUtils.setField(field, field, value);
		if (field.isAccessible()) {
			field.set(obj, value);
		} else {
			field.setAccessible(true);
			field.set(obj, value);
			field.setAccessible(false);
		}
	}
	
	public static Object getInstance(String className) {
		Object obj = null;
		try {
			return Class.forName(className).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
