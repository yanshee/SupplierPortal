package com.supplierportal.poasn.Dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CustomerOrdersDto {

	private long orderId;
	private String customName;
	private String customMobile;
	private String deliveryType;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date orderDate;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date expdeliveryDate;
    private String expdeliveryTime;
    private String status;
    private String shippingAddress;
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public String getCustomName() {
		return customName;
	}
	public void setCustomName(String customName) {
		this.customName = customName;
	}
	public String getCustomMobile() {
		return customMobile;
	}
	public void setCustomMobile(String customMobile) {
		this.customMobile = customMobile;
	}
	public String getDeliveryType() {
		return deliveryType;
	}
	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getExpdeliveryDate() {
		return expdeliveryDate;
	}
	public void setExpdeliveryDate(Date expdeliveryDate) {
		this.expdeliveryDate = expdeliveryDate;
	}
	public String getExpdeliveryTime() {
		return expdeliveryTime;
	}
	public void setExpdeliveryTime(String expdeliveryTime) {
		this.expdeliveryTime = expdeliveryTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public CustomerOrdersDto(long orderId, String customName, String customMobile, String deliveryType, Date orderDate,
			Date expdeliveryDate, String expdeliveryTime, String status, String shippingAddress) {
		super();
		this.orderId = orderId;
		this.customName = customName;
		this.customMobile = customMobile;
		this.deliveryType = deliveryType;
		this.orderDate = orderDate;
		this.expdeliveryDate = expdeliveryDate;
		this.expdeliveryTime = expdeliveryTime;
		this.status = status;
		this.shippingAddress = shippingAddress;
	}
	public CustomerOrdersDto() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	
    
}
