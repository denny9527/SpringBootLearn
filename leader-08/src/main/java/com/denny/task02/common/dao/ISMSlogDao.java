package com.denny.task02.common.dao;

import com.denny.common.IBaseDao;
import com.denny.task02.common.domain.Order;
import com.denny.task02.common.domain.SMSlog;
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

public interface ISMSlogDao extends IBaseDao<SMSlog> {
    @Delete({
        "delete from T_SMS_LOG",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into T_SMS_LOG (USER_ACCOUNT, PHONE_NUMBER, ",
        "SMS_CONTENT, SEND_TIME)",
        "values (#{userAccount,jdbcType=VARCHAR}, #{phoneNumber,jdbcType=VARCHAR}, ",
        "#{smsContent,jdbcType=VARCHAR}, #{sendTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(SMSlog record);

    @Select({
        "select",
        "ID, USER_ACCOUNT, PHONE_NUMBER, SMS_CONTENT, SEND_TIME",
        "from T_SMS_LOG",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    @ConstructorArgs({
        @Arg(column="ID", javaType=Long.class, jdbcType=JdbcType.BIGINT, id=true),
        @Arg(column="USER_ACCOUNT", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="PHONE_NUMBER", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="SMS_CONTENT", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="SEND_TIME", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    SMSlog selectByPrimaryKey(Long id);

    @Select({
        "select",
        "ID, USER_ACCOUNT, PHONE_NUMBER, SMS_CONTENT, SEND_TIME",
        "from T_SMS_LOG"
    })
    @ConstructorArgs({
        @Arg(column="ID", javaType=Long.class, jdbcType=JdbcType.BIGINT, id=true),
        @Arg(column="USER_ACCOUNT", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="PHONE_NUMBER", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="SMS_CONTENT", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="SEND_TIME", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    List<SMSlog> selectAll();

    @Update({
        "update T_SMS_LOG",
        "set USER_ACCOUNT = #{userAccount,jdbcType=VARCHAR},",
          "PHONE_NUMBER = #{phoneNumber,jdbcType=VARCHAR},",
          "SMS_CONTENT = #{smsContent,jdbcType=VARCHAR},",
          "SEND_TIME = #{sendTime,jdbcType=TIMESTAMP}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SMSlog record);
}