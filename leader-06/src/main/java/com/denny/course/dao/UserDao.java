/**   
 * @Title: UserDao.java 
 * @Package com.denny.common.user 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月3日 下午9:43:12 
 * @version V1.0   
 */
package com.denny.course.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.denny.course.common.BaseDao;
import com.denny.course.domain.User;
import com.denny.course.spring.aop.CustomJdbcTemplate;
import com.google.common.base.Joiner;
import com.google.common.base.Strings;

/** 
 * @ClassName: UserDao 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月3日 下午9:43:12 
 *  
 */
@Repository("userDao")
public class UserDao implements BaseDao<User>{
	
	@Autowired
	private CustomJdbcTemplate jdbcTemplate;

	@Override
	public int save(User t) {
		return jdbcTemplate.update("insert into USER(ID, NAME, PASSWORD, ENABLED, REG_TIME) values(?, ?, ?, ?, ?)",
				new Object[] {t.getId(), t.getName(), t.getPassword(), t.getEnabled(), t.getRegTime()});
	}

	@Override
	public int delete(Long id) {
		return jdbcTemplate.update("delete from USER where id = ?", new Object[] {id});
	}

	@Override
	public int update(User t) {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("update USER set ");
		List<Object> paramList = new ArrayList<Object>();
		Long id = t.getId();
		String name = t.getName();
		String password = t.getPassword();
		String enabled = t.getEnabled();
		Date regDate = t.getRegTime();
		List<String> fieldSetList = new ArrayList<String>();
		if (!Strings.isNullOrEmpty(name)) {
			fieldSetList.add("NAME = ?");
			paramList.add(name);
		}
		if (!Strings.isNullOrEmpty(password)) {
			fieldSetList.add("PASSWORD = ?");
			paramList.add(password);
		}
		if (!Strings.isNullOrEmpty(enabled)) {
			fieldSetList.add("ENABLED = ?");
			paramList.add(enabled);
		}
		if (regDate != null) {
			fieldSetList.add("REG_TIME = ?");
			paramList.add(regDate);
		}
		if (!CollectionUtils.isEmpty(fieldSetList)) {
			sqlStr.append(Joiner.on(",").join(fieldSetList) + " ");
		}
		if (id != null) {
			sqlStr.append("where ID =  ?");
			paramList.add(id);
		}
		Object[] params = paramList.toArray();
		return jdbcTemplate.update(sqlStr.toString(), params);
	}

	/* (non-Javadoc) 
	 * <p>Title: queryList</p> 
	 * <p>Description: </p> 
	 * @param t
	 * @return 
	 * @see com.denny.common.BaseDao#queryList(java.lang.Object) 
	 */
	@Override
	public List<User> queryList(User t) {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("select ID, NAME, PASSWORD, ENABLED, REG_TIME from USER where 1 = 1 ");
		List<Object> paramList = new ArrayList<Object>();
		Long id = t.getId();
		String name = t.getName();
		String password = t.getPassword();
		String enabled = t.getEnabled();
		Date regTime = t.getRegTime();
		List<String> conditionList = new ArrayList<String>();
		if (!Strings.isNullOrEmpty(name)) {
			conditionList.add("and NAME = ?");
			paramList.add(name);
		}
		if (!Strings.isNullOrEmpty(password)) {
			conditionList.add("and PASSWORD = ?");
			paramList.add(password);
		}
		if (!Strings.isNullOrEmpty(enabled)) {
			conditionList.add("and ENABLED = ?");
			paramList.add(enabled);
		}
		if (regTime != null) {
			conditionList.add("and REG_TIME = ?");
			paramList.add(regTime);
		}
		if (id != null) {
			sqlStr.append("and ID = ?");
			paramList.add(id);
		}
		if (!CollectionUtils.isEmpty(conditionList)) {
			sqlStr.append(Joiner.on(" ").join(conditionList));
		}
		Object[] params = paramList.toArray();
		return jdbcTemplate.query(sqlStr.toString(), params, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getLong("ID"));
				user.setName(rs.getString("NAME"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setEnabled(rs.getString("ENABLED"));
				user.setRegTime(rs.getDate("REG_TIME"));
				return user;
			}
		});
	}

}
