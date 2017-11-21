package com.denny.task01.common.dao;

import com.denny.common.IBaseDao;
import com.denny.task01.common.domain.User;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.annotation.MapperScan;

public interface IUserDao extends IBaseDao<User> {
    @Delete({
        "delete from T_USER",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into T_USER (NAME, PASSWORD, ",
        "ENABLED, REG_TIME)",
        "values (#{name,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{enabled,jdbcType=CHAR}, #{regTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(User record);

    @Select({
        "select",
        "ID, NAME, PASSWORD, ENABLED, REG_TIME",
        "from T_USER",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    @ConstructorArgs({
        @Arg(column="ID", javaType=Long.class, jdbcType=JdbcType.BIGINT, id=true),
        @Arg(column="NAME", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="PASSWORD", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="ENABLED", javaType=String.class, jdbcType=JdbcType.CHAR),
        @Arg(column="REG_TIME", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    User selectByPrimaryKey(Long id);

    @Select({
        "select",
        "ID, NAME, PASSWORD, ENABLED, REG_TIME",
        "from T_USER"
    })
    @ConstructorArgs({
        @Arg(column="ID", javaType=Long.class, jdbcType=JdbcType.BIGINT, id=true),
        @Arg(column="NAME", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="PASSWORD", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="ENABLED", javaType=String.class, jdbcType=JdbcType.CHAR),
        @Arg(column="REG_TIME", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    List<User> selectAll();

    @Update({
        "update T_USER",
        "set NAME = #{name,jdbcType=VARCHAR},",
          "PASSWORD = #{password,jdbcType=VARCHAR},",
          "ENABLED = #{enabled,jdbcType=CHAR},",
          "REG_TIME = #{regTime,jdbcType=TIMESTAMP}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(User record);
}