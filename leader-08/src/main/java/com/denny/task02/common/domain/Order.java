package com.denny.task02.common.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Order {

    private Long id;

    private String orderId;

    private String userAccount;

    private String productId;

    private String productName;

    private Long productQuantity;

    private BigDecimal totalAmount;

    private Date createTime;
    
    private String phoneNumber;

    public Order(Long id, String orderId, String userAccount, String productId, String productName, Long productQuantity, BigDecimal totalAmount, Date createTime, String phoneNumber) {
        this.id = id;
        this.orderId = orderId;
        this.userAccount = userAccount;
        this.productId = productId;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.totalAmount = totalAmount;
        this.createTime = createTime;
        this.phoneNumber = phoneNumber;
    }

    public Order() {
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

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Long getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Long productQuantity) {
        this.productQuantity = productQuantity;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	/** 
	 * @return phoneNumber 
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}