/**   
 * @Title: Order.java 
 * @Package com.denny.jdk.event 
 * @Description: TODO
 * @author Zhangkui zhangkui_java@163.com   
 * @date 2017年9月2日 下午7:56:45 
 * @version V1.0   
 */
package com.denny.jdk.event;

import java.math.BigDecimal;
import java.util.Date;

/** 
 * @ClassName: Order 
 * @Description: 订单实体类
 * @author Zhangkui zhangkui_java@163.com 
 * @date 2017年9月2日 下午7:56:45 
 *  
 */
public class Order {
	
	/**
	 * 订单流水号
	 */
	private String orderSerialNum;
	
	/**
	 * 产品数量
	 */
	private Long productCount;
	
	/**
	 * 产品名称
	 */
	private String productName;
	
	/**
	 * 产品单价
	 */
	private BigDecimal productUnitPrice;
	
	/**
	 * 订单总价
	 */
	private BigDecimal orderTotalPrice;

	/**
	 * 卖家名称
	 */
	private String sellerName;
	
	/**
	 * 买家名称
	 */
	private String  buyerName;
	
	/**
	 * 下单时间
	 */
	private Date orderTime;
	
	
	/** 
	 * @return orderSerialNum 
	 */
	public String getOrderSerialNum() {
		return orderSerialNum;
	}


	/**
	 * @param orderSerialNum the orderSerialNum to set
	 */
	public void setOrderSerialNum(String orderSerialNum) {
		this.orderSerialNum = orderSerialNum;
	}


	/** 
	 * @return productCount 
	 */
	public Long getProductCount() {
		return productCount;
	}


	/**
	 * @param productCount the productCount to set
	 */
	public void setProductCount(Long productCount) {
		this.productCount = productCount;
	}


	/** 
	 * @return productName 
	 */
	public String getProductName() {
		return productName;
	}


	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}


	/** 
	 * @return productUnitPrice 
	 */
	public BigDecimal getProductUnitPrice() {
		return productUnitPrice;
	}


	/**
	 * @param productUnitPrice the productUnitPrice to set
	 */
	public void setProductUnitPrice(BigDecimal productUnitPrice) {
		this.productUnitPrice = productUnitPrice;
	}


	/** 
	 * @return orderTotalPrice 
	 */
	public BigDecimal getOrderTotalPrice() {
		return orderTotalPrice;
	}


	/**
	 * @param orderTotalPrice the orderTotalPrice to set
	 */
	public void setOrderTotalPrice(BigDecimal orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}


	/** 
	 * @return sellerName 
	 */
	public String getSellerName() {
		return sellerName;
	}


	/**
	 * @param sellerName the sellerName to set
	 */
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}


	/** 
	 * @return buyerName 
	 */
	public String getBuyerName() {
		return buyerName;
	}


	/**
	 * @param buyerName the buyerName to set
	 */
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}


	/** 
	 * @return orderTime 
	 */
	public Date getOrderTime() {
		return orderTime;
	}


	/**
	 * @param orderTime the orderTime to set
	 */
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}


	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */
	public Order() {
		// TODO Auto-generated constructor stub
	}


	/* (non-Javadoc) 
	 * <p>Title: toString</p> 
	 * <p>Description: </p> 
	 * @return 
	 * @see java.lang.Object#toString() 
	 */
	@Override
	public String toString() {
		return "Order [orderSerialNum=" + orderSerialNum + ", productCount=" + productCount + ", productName="
				+ productName + ", productUnitPrice=" + productUnitPrice + ", orderTotalPrice=" + orderTotalPrice
				+ ", sellerName=" + sellerName + ", buyerName=" + buyerName + ", orderTime=" + orderTime + "]";
	}

}
