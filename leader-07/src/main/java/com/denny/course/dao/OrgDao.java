/**   
 * @Title: OrgDao.java 
 * @Package com.denny.course.dao 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月17日 上午8:15:07 
 * @version V1.0   
 */
package com.denny.course.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.denny.course.common.BaseDao;
import com.denny.course.domain.Org;
import com.denny.course.domain.User;
import com.denny.spring.transaction.CustomJdbcTemplate;
import com.google.common.base.Joiner;
import com.google.common.base.Strings;

/** 
 * @ClassName: OrgDao 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月17日 上午8:15:07 
 *  
 */
@Repository("orgDao")
public class OrgDao implements BaseDao<Org>{
	
	@Autowired
	private CustomJdbcTemplate jdbcTemplate;

	@Override
	public int save(Org t) {
		return jdbcTemplate.update("insert into ORG(ID, ORG_NAME, ORG_ADDRESS) values(?, ?, ?)",
				new Object[] {t.getId(), t.getOrgName(), t.getOrgAddress()});
	}

	@Override
	public int delete(Long id) {
		return jdbcTemplate.update("delete from ORG where id = ?", new Object[] {id});
	}

	@Override
	public int update(Org t) {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("update ORG set ");
		List<Object> paramList = new ArrayList<Object>();
		Long id = t.getId();
		String orgName = t.getOrgName();
		String orgAdress = t.getOrgAddress();
		List<String> fieldSetList = new ArrayList<String>();
		if (!Strings.isNullOrEmpty(orgName)) {
			fieldSetList.add("ORG_NAME = ?");
			paramList.add(orgName);
		}
		if (!Strings.isNullOrEmpty(orgAdress)) {
			fieldSetList.add("ORG_ADDRESS = ?");
			paramList.add(orgAdress);
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

	@Override
	public List<Org> queryList(Org t) {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("select ID, ORG_NAME, ORG_ADDRESS from ORG where 1 = 1 ");
		List<Object> paramList = new ArrayList<Object>();
		Long id = t.getId();
		String orgName = t.getOrgName();
		String orgAdress = t.getOrgAddress();
		List<String> conditionList = new ArrayList<String>();
		if (!Strings.isNullOrEmpty(orgName)) {
			conditionList.add("and ORG_NAME = ?");
			paramList.add(orgName);
		}
		if (!Strings.isNullOrEmpty(orgAdress)) {
			conditionList.add("and ORG_ADDRESS = ?");
			paramList.add(orgAdress);
		}
		if (id != null) {
			sqlStr.append("and ID = ?");
			paramList.add(id);
		}
		if (!CollectionUtils.isEmpty(conditionList)) {
			sqlStr.append(Joiner.on(" ").join(conditionList));
		}
		Object[] params = paramList.toArray();
		return jdbcTemplate.query(sqlStr.toString(), params, new RowMapper<Org>() {
			@Override
			public Org mapRow(ResultSet rs, int rowNum) throws SQLException {
				Org org = new Org();
				org.setId(rs.getLong("ID"));
				org.setOrgAddress(rs.getString("ORG_ADDRESS"));
				org.setOrgName(rs.getString("ORG_NAME"));
				return org;
			}
		});
	}

}
