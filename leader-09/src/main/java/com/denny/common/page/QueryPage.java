/**   
 * @Title: QueryPage.java 
 * @Package: com.denny.cmomon.page
 * @Description: 查询基础类(支持分页查询[oracle/mysql])
 * @author Zhang Kui
 * @date 2017年8月26日 下午2:05:23 
 * @version V1.0.0
 */
package com.denny.common.page;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: QueryPage 
 * @Description: TODO 
 * @author Zhang Kui
 * @date 2017年8月26日 下午2:05:23 
 */
public abstract class QueryPage implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(QueryPage.class);
    
	private static final long serialVersionUID = 7603300820027561064L;
	
    /**
     * 默认每页数据条数
     */
	private static final Integer defaultPageSize = new Integer(20);

    /**
     * 默认当前页数
     */
	private static final Integer defaultFriatPage = new Integer(1);

    /**
     * 默认数据总条数
     */
	private static final Integer defaultTotleItem = new Integer(0);
	private Integer totalItem;
	private Integer pageSize;
	private Integer currentPage;

	public QueryPage() {
		
	}

	protected final Integer getDefaultPageSize() {
		return defaultPageSize;
	}

	public boolean isFirstPage() {
		return getCurrentPage().intValue() == 1;
	}

	public int getPreviousPage() {
		int back = getCurrentPage().intValue() - 1;

		if (back <= 0) {
			back = 1;
		}
		return back;
	}

	public boolean isLastPage() {
		return getTotalPage() == getCurrentPage().intValue();
	}

	public int getNextPage() {
		int back = getCurrentPage().intValue() + 1;

		if (back > getTotalPage()) {
			back = getTotalPage();
		}

		return back;
	}

	public Integer getCurrentPage() {
		if (this.currentPage == null) {
			return defaultFriatPage;
		}

		return this.currentPage;
	}

	public void setCurrentPage(Integer cPage) {
		if ((cPage == null) || (cPage.intValue() <= 0))
			this.currentPage = defaultFriatPage;
		else
			this.currentPage = cPage;
	}

	public void setCurrentPageString(String s) {
		if (s == null || s.trim().equals(""))
			return;
		try {
			setCurrentPage(Integer.valueOf(Integer.parseInt(s)));
		} catch (NumberFormatException ignore) {
			setCurrentPage(defaultFriatPage);
		}
	}

	public Integer getPageSize() {
		if (this.pageSize == null) {
			return getDefaultPageSize();
		}

		return this.pageSize;
	}

	public boolean hasSetPageSize() {
		return this.pageSize != null;
	}

	public void setPageSize(Integer pSize) {
		if (pSize == null || pSize.intValue() <= 0) {
			pSize = defaultPageSize;
		}
		this.pageSize = pSize;
	}

	public void setPageSizeString(String pageSizeString) {
		if (pageSizeString == null || pageSizeString.trim().equals("")) {
			return;
		}
		try {
			Integer integer = new Integer(pageSizeString);
			setPageSize(integer);
		} catch (NumberFormatException localNumberFormatException) {
		}
	}

	public Integer getTotalItem() {
		if (this.totalItem == null) {
			return defaultTotleItem;
		}
		return this.totalItem;
	}

	public void setTotalItem(Integer tItem) {
		if (tItem == null) {
			tItem = new Integer(0);
		}
		this.totalItem = tItem;
		int current = getCurrentPage().intValue();
		int lastPage = getTotalPage();
		if (current > lastPage && lastPage != 0)
			setCurrentPage(new Integer(lastPage));
	}

	public int getTotalPage() {
		int pgSize = getPageSize().intValue();
		int total = getTotalItem().intValue();
		int result = total / pgSize;
		if (total % pgSize != 0) {
			result++;
		}
		return result;
	}

	public int getPageFristItem() {
		int cPage = getCurrentPage().intValue();
		if (cPage == 1) {
			return 0;
		}
		cPage--;
		int pgSize = getPageSize().intValue();

		return pgSize * cPage;
	}

	public int getPageLastItem() {
		int assumeLast = getExpectPageLastItem();
		int totalItem = getTotalItem().intValue();

		if (assumeLast > totalItem) {
			return totalItem;
		}
		return assumeLast;
	}

	public int getExpectPageLastItem() {
		int cPage = getCurrentPage().intValue();
		int pgSize = getPageSize().intValue();
		return pgSize * cPage;
	}
	
	public Map<String, String> getParameters() {
		Class<?> clazz = this.getClass();
		HashMap<String, String> resMap = new HashMap<String, String>();
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			getClass(clazz, map, this);
			resMap = convertHashMap(map);
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("{}", e);
			}
		}
		return resMap;
	}

	private static void getClass(Class<?> clazz, HashMap<String, Object> map,
			Object obj) throws Exception {
		if (clazz.getSimpleName().equals("Object")) {
			return;
		}
		Field[] fields = clazz.getDeclaredFields();
		if ((fields != null) && (fields.length > 0)) {
			for (int i = 0; i < fields.length; i++) {
				fields[i].setAccessible(true);
				String name = fields[i].getName();
				if (!"serialVersionUID".equals(name) && !"logger".equals(name)) {
					Object value = fields[i].get(obj);
					map.put(name, value);
				}
			}
		}
	}

	private static HashMap<String, String> convertHashMap(
			HashMap<String, Object> map) throws Exception {
		HashMap<String, String> newMap = new HashMap<String, String>();
		Set<String> keys = map.keySet();
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String key = it.next();
			convertToString(map.get(key), newMap, key);
		}

		return newMap;
	}

	private static void convertToString(Object value,
			HashMap<String, String> newMap, String key) {
		if (value != null) {
			Class<?> clazz = value.getClass();
			if (isBaseType(clazz)) {
				newMap.put(key, value.toString());
			} else if (clazz == String.class) {
				newMap.put(key, value.toString());
			} else if (clazz == java.util.Date.class) {
				java.util.Date date = (java.util.Date) value;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				newMap.put(key, sdf.format(date));
			} else if (clazz == Timestamp.class) {
				Timestamp timestamp = (Timestamp) value;
				long times = timestamp.getTime();
				java.util.Date date = new java.util.Date(times);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				newMap.put(key, sdf.format(date));
			} else if (clazz == java.sql.Date.class) {
				java.sql.Date sqlDate = (java.sql.Date) value;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				newMap.put(key, sdf.format(sqlDate));
			} else {
				newMap.put(key, value.toString());
			}
		}
	}

	private static boolean isBaseType(Class<?> clazz) {
		boolean isBaseType = false;

		if (clazz == Integer.class) {
			isBaseType = true;
		}
		if (clazz == Long.class) {
			isBaseType = true;
		}
		if (clazz == Double.class) {
			isBaseType = true;
		}
		if (clazz == Byte.class) {
			isBaseType = true;
		}
		if (clazz == Float.class) {
			isBaseType = true;
		}
		if (clazz == Short.class) {
			isBaseType = true;
		}
		if (clazz == Boolean.class) {
			isBaseType = true;
		}
		return isBaseType;
	}

}
