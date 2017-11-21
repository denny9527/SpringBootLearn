package com.denny.task02.common.dao;

import com.denny.common.IBaseDao;
import com.denny.task02.common.domain.Order;
import com.denny.task02.common.domain.OrderOperationLog;
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

public interface IOrderOperationLogDao extends IBaseDao<OrderOperationLog> {
    @Delete({
        "delete from T_ORDER_OPERATION_LOG",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into T_ORDER_OPERATION_LOG (ORDER_ID, LOG_CONTENT, ",
        "OPERATOR, OPERATOR_TYPE, ",
        "OPERATION_TIME)",
        "values (#{orderId,jdbcType=VARCHAR}, #{logContent,jdbcType=VARCHAR}, ",
        "#{operator,jdbcType=VARCHAR}, #{operatorType,jdbcType=CHAR}, ",
        "#{operationTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(OrderOperationLog record);

    @Select({
        "select",
        "ID, ORDER_ID, LOG_CONTENT, OPERATOR, OPERATOR_TYPE, OPERATION_TIME",
        "from T_ORDER_OPERATION_LOG",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    @ConstructorArgs({
        @Arg(column="ID", javaType=Long.class, jdbcType=JdbcType.BIGINT, id=true),
        @Arg(column="ORDER_ID", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="LOG_CONTENT", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="OPERATOR", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="OPERATOR_TYPE", javaType=String.class, jdbcType=JdbcType.CHAR),
        @Arg(column="OPERATION_TIME", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    OrderOperationLog selectByPrimaryKey(Long id);

    @Select({
        "select",
        "ID, ORDER_ID, LOG_CONTENT, OPERATOR, OPERATOR_TYPE, OPERATION_TIME",
        "from T_ORDER_OPERATION_LOG"
    })
    @ConstructorArgs({
        @Arg(column="ID", javaType=Long.class, jdbcType=JdbcType.BIGINT, id=true),
        @Arg(column="ORDER_ID", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="LOG_CONTENT", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="OPERATOR", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="OPERATOR_TYPE", javaType=String.class, jdbcType=JdbcType.CHAR),
        @Arg(column="OPERATION_TIME", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    List<OrderOperationLog> selectAll();

    @Update({
        "update T_ORDER_OPERATION_LOG",
        "set ORDER_ID = #{orderId,jdbcType=VARCHAR},",
          "LOG_CONTENT = #{logContent,jdbcType=VARCHAR},",
          "OPERATOR = #{operator,jdbcType=VARCHAR},",
          "OPERATOR_TYPE = #{operatorType,jdbcType=CHAR},",
          "OPERATION_TIME = #{operationTime,jdbcType=TIMESTAMP}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OrderOperationLog record);
}