package com.denny.task02.common.dao;

import com.denny.common.IBaseDao;
import com.denny.task02.common.domain.Order;
import java.math.BigDecimal;
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

public interface IOrderDao extends IBaseDao<Order> {
    @Delete({
        "delete from T_ORDER",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into T_ORDER (ORDER_ID, USER_ACCOUNT, ",
        "PRODUCT_ID, PRODUCT_NAME, ",
        "PRODUCT_QUANTITY, TOTAL_AMOUNT, ",
        "CREATE_TIME)",
        "values (#{orderId,jdbcType=VARCHAR}, #{userAccount,jdbcType=VARCHAR}, ",
        "#{productId,jdbcType=VARCHAR}, #{productName,jdbcType=VARCHAR}, ",
        "#{productQuantity,jdbcType=BIGINT}, #{totalAmount,jdbcType=DECIMAL}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(Order record);

    @Select({
        "select",
        "ID, ORDER_ID, USER_ACCOUNT, PRODUCT_ID, PRODUCT_NAME, PRODUCT_QUANTITY, TOTAL_AMOUNT, ",
        "CREATE_TIME",
        "from T_ORDER",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    @ConstructorArgs({
        @Arg(column="ID", javaType=Long.class, jdbcType=JdbcType.BIGINT, id=true),
        @Arg(column="ORDER_ID", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="USER_ACCOUNT", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="PRODUCT_ID", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="PRODUCT_NAME", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="PRODUCT_QUANTITY", javaType=Long.class, jdbcType=JdbcType.BIGINT),
        @Arg(column="TOTAL_AMOUNT", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
        @Arg(column="CREATE_TIME", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    Order selectByPrimaryKey(Long id);

    @Select({
        "select",
        "ID, ORDER_ID, USER_ACCOUNT, PRODUCT_ID, PRODUCT_NAME, PRODUCT_QUANTITY, TOTAL_AMOUNT, ",
        "CREATE_TIME",
        "from T_ORDER"
    })
    @ConstructorArgs({
        @Arg(column="ID", javaType=Long.class, jdbcType=JdbcType.BIGINT, id=true),
        @Arg(column="ORDER_ID", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="USER_ACCOUNT", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="PRODUCT_ID", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="PRODUCT_NAME", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="PRODUCT_QUANTITY", javaType=Long.class, jdbcType=JdbcType.BIGINT),
        @Arg(column="TOTAL_AMOUNT", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
        @Arg(column="CREATE_TIME", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    List<Order> selectAll();

    @Update({
        "update T_ORDER",
        "set ORDER_ID = #{orderId,jdbcType=VARCHAR},",
          "USER_ACCOUNT = #{userAccount,jdbcType=VARCHAR},",
          "PRODUCT_ID = #{productId,jdbcType=VARCHAR},",
          "PRODUCT_NAME = #{productName,jdbcType=VARCHAR},",
          "PRODUCT_QUANTITY = #{productQuantity,jdbcType=BIGINT},",
          "TOTAL_AMOUNT = #{totalAmount,jdbcType=DECIMAL},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Order record);
}