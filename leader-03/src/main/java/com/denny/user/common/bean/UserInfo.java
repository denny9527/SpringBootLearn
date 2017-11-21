/**
 * @Title: UserInfo.java
 * @Package: com.denny.user.common.bean
 * @Description: 
 * @author Zhang Kui
 * @date 2017年08月26日 下午09:34:57
 * @version V1.0.0
 */
package com.denny.user.common.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据库表：USER_INFO
 * @ClassName: UserInfo
 * @Description: 
 * @author Zhang Kui
 * @date 2017年08月26日 下午09:34:57
 * @version 1.0.0 
 */
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     * 表字段：USER_INFO.ID
     */
    private Long id;

    /**
     * 用户ID
     * 表字段：USER_INFO.USER_ID
     */
    private String userId;

    /**
     * 用户姓名
     * 表字段：USER_INFO.USER_NAME
     */
    private String userName;

    /**
     * 密码
     * 表字段：USER_INFO.PASSWORD
     */
    private String password;

    /**
     * 是否启用
     * 表字段：USER_INFO.ENABLED
     */
    private String enabled;

    /**
     * 注册时间
     * 表字段：USER_INFO.REGDATE
     */
    private Date regdate;

    /**
     * 获取 主键ID 字段：USER_INFO.ID
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 主键ID 字段：USER_INFO.ID
     *
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 用户ID 字段：USER_INFO.USER_ID
     *
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置 用户ID 字段：USER_INFO.USER_ID
     *
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取 用户姓名 字段：USER_INFO.USER_NAME
     *
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置 用户姓名 字段：USER_INFO.USER_NAME
     *
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取 密码 字段：USER_INFO.PASSWORD
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置 密码 字段：USER_INFO.PASSWORD
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取 是否启用 字段：USER_INFO.ENABLED
     *
     * @return the enabled
     */
    public String getEnabled() {
        return enabled;
    }

    /**
     * 设置 是否启用 字段：USER_INFO.ENABLED
     *
     * @param enabled the enabled to set
     */
    public void setEnabled(String enabled) {
        this.enabled = enabled == null ? null : enabled.trim();
    }

    /**
     * 获取 注册时间 字段：USER_INFO.REGDATE
     *
     * @return the regdate
     */
    public Date getRegdate() {
        return regdate;
    }

    /**
     * 设置 注册时间 字段：USER_INFO.REGDATE
     *
     * @param regdate the regdate to set
     */
    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", password=").append(password);
        sb.append(", enabled=").append(enabled);
        sb.append(", regdate=").append(regdate);
        sb.append("]");
        return sb.toString();
    }
}