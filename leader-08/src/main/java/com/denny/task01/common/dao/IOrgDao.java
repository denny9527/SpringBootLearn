package com.denny.task01.common.dao;

import com.denny.common.IBaseDao;
import com.denny.task01.common.domain.Org;
import com.denny.task01.common.domain.User;

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

public interface IOrgDao extends IBaseDao<Org> {
    @Delete({
        "delete from T_ORG",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into T_ORG (ORG_NAME, ORG_ADDRESS)",
        "values (#{orgName,jdbcType=VARCHAR}, #{orgAddress,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(Org record);

    @Select({
        "select",
        "ID, ORG_NAME, ORG_ADDRESS",
        "from T_ORG",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    @ConstructorArgs({
        @Arg(column="ID", javaType=Long.class, jdbcType=JdbcType.BIGINT, id=true),
        @Arg(column="ORG_NAME", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="ORG_ADDRESS", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    Org selectByPrimaryKey(Long id);

    @Select({
        "select",
        "ID, ORG_NAME, ORG_ADDRESS",
        "from T_ORG"
    })
    @ConstructorArgs({
        @Arg(column="ID", javaType=Long.class, jdbcType=JdbcType.BIGINT, id=true),
        @Arg(column="ORG_NAME", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="ORG_ADDRESS", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    List<Org> selectAll();

    @Update({
        "update T_ORG",
        "set ORG_NAME = #{orgName,jdbcType=VARCHAR},",
          "ORG_ADDRESS = #{orgAddress,jdbcType=VARCHAR}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Org record);
}