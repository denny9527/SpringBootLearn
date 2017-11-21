/**
 * @Title: User.java
 * @Package: edu.ldcollege.domain
 * @Description: 
 * @author Zhang Kui
 * @date 2017年10月14日 下午03:47:49
 * @version V1.0.0
 */
package edu.ldcollege.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据库表：T_USER
 * @ClassName: User
 * @Description: 
 * @author Zhang Kui
 * @date 2017年10月14日 下午03:47:49
 * @version 1.0.0 
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 记录ID
     * 表字段：T_USER.ID
     */
    private Long id;

    /**
     * 学员姓名
     * 表字段：T_USER.USER_NAME
     */
    private String userName;

    /**
     * 学员账号
     * 表字段：T_USER.USER_ACCOUNT
     */
    private String userAccount;

    /**
     * 手机号码
     * 表字段：T_USER.PHONE_NUMBER
     */
    private String phoneNumber;

    /**
     * 密码
     * 表字段：T_USER.PASSWORD
     */
    private String password;

    /**
     * 注册时间
     * 表字段：T_USER.REG_DATE
     */
    private Date regDate;

    /**
     * 获取 记录ID 字段：T_USER.ID
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 记录ID 字段：T_USER.ID
     *
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 学员姓名 字段：T_USER.USER_NAME
     *
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置 学员姓名 字段：T_USER.USER_NAME
     *
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取 学员账号 字段：T_USER.USER_ACCOUNT
     *
     * @return the userAccount
     */
    public String getUserAccount() {
        return userAccount;
    }

    /**
     * 设置 学员账号 字段：T_USER.USER_ACCOUNT
     *
     * @param userAccount the userAccount to set
     */
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    /**
     * 获取 手机号码 字段：T_USER.PHONE_NUMBER
     *
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置 手机号码 字段：T_USER.PHONE_NUMBER
     *
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    /**
     * 获取 密码 字段：T_USER.PASSWORD
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置 密码 字段：T_USER.PASSWORD
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取 注册时间 字段：T_USER.REG_DATE
     *
     * @return the regDate
     */
    public Date getRegDate() {
        return regDate;
    }

    /**
     * 设置 注册时间 字段：T_USER.REG_DATE
     *
     * @param regDate the regDate to set
     */
    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userName=").append(userName);
        sb.append(", userAccount=").append(userAccount);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", password=").append(password);
        sb.append(", regDate=").append(regDate);
        sb.append("]");
        return sb.toString();
    }
}