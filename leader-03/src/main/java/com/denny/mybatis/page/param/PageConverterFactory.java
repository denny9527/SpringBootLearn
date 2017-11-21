/**   
 * @Title: PageConverterFactory.java 
 * @Package com.denny.mybatis.page.param 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年8月24日 下午4:28:37 
 * @version V1.0   
 */
package com.denny.mybatis.page.param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: PageConverterFactory
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年8月24日 下午4:28:37
 * 
 */
public class PageConverterFactory {

	private List<String> converters;

	private Map<String, Class<IPageConverter>> converterMap = new HashMap(3);

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	public PageConverterFactory() {
		// TODO Auto-generated constructor stub
	}

	public void setConverters(List<String> converters) {
		this.converters = converters;
		try {
			for (String converter : converters) {
				Class clazz = Class.forName(converter);
				Class tclz = (Class) ((java.lang.reflect.ParameterizedType) clazz.getGenericInterfaces()[0])
						.getActualTypeArguments()[0];
				this.converterMap.put(tclz.getName(), clazz);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public IPageConverter createPageConverter(Object dto) throws Exception {
		for (Class superClass = dto.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
			Class pcClz = (Class) this.converterMap.get(superClass.getName());

			if (pcClz != null) {
				IPageConverter pc = (IPageConverter) pcClz.newInstance();
				return pc;
			}
		}
		return null;
	}
}
