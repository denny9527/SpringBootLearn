package com.denny.task02.common.domain;

import java.util.Date;

public class OrderOperationLog {

    private Long id;

    private String orderId;

    private String logContent;

    private String operator;

    private String operatorType;

    private Date operationTime;

    public OrderOperationLog(Long id, String orderId, String logContent, String operator, String operatorType, Date operationTime) {
        this.id = id;
        this.orderId = orderId;
        this.logContent = logContent;
        this.operator = operator;
        this.operatorType = operatorType;
        this.operationTime = operationTime;
    }

    public OrderOperationLog() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent == null ? null : logContent.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType == null ? null : operatorType.trim();
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }
}