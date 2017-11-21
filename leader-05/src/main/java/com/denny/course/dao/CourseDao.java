/**   
 * @Title: CourseDao.java 
 * @Package com.denny.course.dao 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月9日 上午10:06:37 
 * @version V1.0   
 */
package com.denny.course.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.denny.common.dao.IBaseDao;
import com.denny.course.domain.Course;
import com.denny.course.query.CourseQuery;
import com.google.common.base.Joiner;
import com.google.common.base.Strings;

/**
 * @ClassName: CourseDao
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com
 * @date 2017年9月9日 上午10:06:37
 * 
 */
@Component("courseDao")
public class CourseDao implements IBaseDao<Course, Long, CourseQuery> {

	@Autowired(required = false)
	private JdbcTemplate jdbcTemplate;

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	public CourseDao() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc) <p>Title: save</p> <p>Description: </p>
	 * 
	 * @param t
	 * 
	 * @return
	 * 
	 * @see com.denny.common.dao.IBaseDao#save(java.lang.Object)
	 */
	@Override
	public int save(Course t) {
		return jdbcTemplate.update("insert into course(name, mark) values(?, ?)",
				new Object[] { t.getName(), t.getMark() });
	}

	/*
	 * (non-Javadoc) <p>Title: batchSave</p> <p>Description: </p>
	 * 
	 * @param tList
	 * 
	 * @return
	 * 
	 * @see com.denny.common.dao.IBaseDao#batchSave(java.util.List)
	 */
	@Override
	public int batchSave(List<Course> tList) {
		int totalCount = 0;
		List<Object[]> batchArgs = new ArrayList<Object[]>();
		for (Course course : tList) {
			batchArgs.add(new Object[] { course.getName(), course.getMark() });
		}
		int[] counts = jdbcTemplate.batchUpdate("insert into course(name, mark) values(?, ?)", batchArgs);
		for (int count : counts) {
			totalCount += count;
		}
		return totalCount;
	}

	/*
	 * (non-Javadoc) <p>Title: update</p> <p>Description: </p>
	 * 
	 * @param t
	 * 
	 * @return
	 * 
	 * @see com.denny.common.dao.IBaseDao#update(java.lang.Object)
	 */
	@Override
	public int update(Course t) {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("update course set ");
		List<Object> paramList = new ArrayList<Object>();
		Long id = t.getId();
		String name = t.getName();
		BigDecimal mark = t.getMark();
		List<String> fieldSetList = new ArrayList<String>();
		if (!Strings.isNullOrEmpty(name)) {
			fieldSetList.add("name = ?");
			paramList.add(name);
		}
		if (mark != null) {
			fieldSetList.add("mark = ?");
			paramList.add(mark);
		}
		if (!CollectionUtils.isEmpty(fieldSetList)) {
			sqlStr.append(Joiner.on(",").join(fieldSetList) + " ");
		}
		if (id != null) {
			sqlStr.append("where id =  ?");
			paramList.add(id);
		}
		Object[] params = paramList.toArray();
		return jdbcTemplate.update(sqlStr.toString(), params);
	}

	/*
	 * (non-Javadoc) <p>Title: deleteById</p> <p>Description: </p>
	 * 
	 * @param pk
	 * 
	 * @return
	 * 
	 * @see com.denny.common.dao.IBaseDao#deleteById(java.lang.Object)
	 */
	@Override
	public int deleteById(Long pk) {
		return jdbcTemplate.update("delete from course where id = ?", new Object[] { pk });
	}

	/*
	 * (non-Javadoc) <p>Title: deleteByIds</p> <p>Description: </p>
	 * 
	 * @param pkList
	 * 
	 * @return
	 * 
	 * @see com.denny.common.dao.IBaseDao#deleteByIds(java.util.List)
	 */
	@Override
	public int deleteByIds(List<Long> pkList) {
		int totalCount = 0;
		List<Object[]> batchArgs = new ArrayList<Object[]>();
		for (Long id : pkList) {
			batchArgs.add(new Object[] { id });
		}
		int[] counts = jdbcTemplate.batchUpdate("delete from course where id = ?", batchArgs);
		for (int count : counts) {
			totalCount += count;
		}
		return totalCount;
	}

	@Override
	public Course getById(Long pk) {
		return jdbcTemplate.queryForObject("select id, name, mark from course where id = ?", new Object[] { pk },
				new RowMapper<Course>() {
					@Override
					public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
						Course course = new Course();
						course.setId(rs.getLong("id"));
						course.setName(rs.getString("name"));
						course.setMark(rs.getBigDecimal("mark"));
						return course;
					}

				});
	}

	@Override
	public List<Course> queryList(CourseQuery p) {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("select id, name, mark from course where 1 = 1 ");
		List<Object> paramList = new ArrayList<Object>();
		Long id = p.getId();
		String name = p.getName();
		BigDecimal mark = p.getMark();
		List<String> conditionList = new ArrayList<String>();
		if (!Strings.isNullOrEmpty(name)) {
			conditionList.add("and name = ?");
			paramList.add(name);
		}
		if (mark != null) {
			conditionList.add("and mark = ?");
			paramList.add(mark);
		}
		if (id != null) {
			sqlStr.append("and id = ?");
			paramList.add(id);
		}
		if (!CollectionUtils.isEmpty(conditionList)) {
			sqlStr.append(Joiner.on(" ").join(conditionList));
		}
		Object[] params = paramList.toArray();
		return jdbcTemplate.query(sqlStr.toString(), params, new RowMapper<Course>() {
			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				Course course = new Course();
				course.setId(rs.getLong("id"));
				course.setName(rs.getString("name"));
				course.setMark(rs.getBigDecimal("mark"));
				return course;
			}

		});
	}

	/*
	 * (non-Javadoc) <p>Title: queryCount</p> <p>Description: </p>
	 * 
	 * @param p
	 * 
	 * @return
	 * 
	 * @see com.denny.common.dao.IBaseDao#queryCount(java.lang.Object)
	 */
	@Override
	public Long queryCount(CourseQuery p) {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("select count(1) as TOTAL_COUNT from course where 1 = 1 ");
		List<Object> paramList = new ArrayList<Object>();
		Long id = p.getId();
		String name = p.getName();
		BigDecimal mark = p.getMark();
		List<String> conditionList = new ArrayList<String>();
		if (!Strings.isNullOrEmpty(name)) {
			conditionList.add("and name = ?");
			paramList.add(name);
		}
		if (mark != null) {
			conditionList.add("and mark = ?");
			paramList.add(mark);
		}
		if (id != null) {
			sqlStr.append("and id = ?");
			paramList.add(id);
		}
		if (!CollectionUtils.isEmpty(conditionList)) {
			sqlStr.append(Joiner.on(" ").join(conditionList));
		}
		Object[] params = paramList.toArray();
		return jdbcTemplate.queryForObject(sqlStr.toString(), new RowMapper<Long>() {
			@Override
			public Long mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getLong("TOTAL_COUNT");
			}

		});
	}

}
