package com.denny.task02.common.domain;

import java.util.Date;

public class SMSlog {

    private Long id;

    private String userAccount;

    private String phoneNumber;

    private String smsContent;

    private Date sendTime;

    public SMSlog(Long id, String userAccount, String phoneNumber, String smsContent, Date sendTime) {
        this.id = id;
        this.userAccount = userAccount;
        this.phoneNumber = phoneNumber;
        this.smsContent = smsContent;
        this.sendTime = sendTime;
    }

    public SMSlog() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getSmsContent() {
        return smsContent;
    }

    public void setSmsContent(String smsContent) {
        this.smsContent = smsContent == null ? null : smsContent.trim();
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}