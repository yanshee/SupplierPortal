package com.supplierportal.poasn.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@SQLDelete(sql = "UPDATE CustomerOrderItems SET deleted = true WHERE itemId=?")
@Where(clause = "deleted=false")
public class CustomerOrderItems {
	@Id
	private Long itemId;
	private String itemDescription;
	private Long orderQty;
	private String fulfillmentId;
	private String ewayBill;
	private String awb;
	private String tpl;
	private String dispatchLocation;
	private String shipmentStatus;
	private boolean deleted = Boolean.FALSE;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderId", referencedColumnName = "orderId")
	private CustomerOrders customerOrder;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public Long getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(Long orderQty) {
		this.orderQty = orderQty;
	}

	public String getFulfillmentId() {
		return fulfillmentId;
	}

	public void setFulfillmentId(String fulfillmentId) {
		this.fulfillmentId = fulfillmentId;
	}

	public String getEwayBill() {
		return ewayBill;
	}

	public void setEwayBill(String ewayBill) {
		this.ewayBill = ewayBill;
	}

	public String getAwb() {
		return awb;
	}

	public void setAwb(String awb) {
		this.awb = awb;
	}

	public String getTpl() {
		return tpl;
	}

	public void setTpl(String tpl) {
		this.tpl = tpl;
	}

	public String getDispatchLocation() {
		return dispatchLocation;
	}

	public void setDispatchLocation(String dispatchLocation) {
		this.dispatchLocation = dispatchLocation;
	}

	public String getShipmentStatus() {
		return shipmentStatus;
	}

	public void setShipmentStatus(String shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}

	public CustomerOrders getCustomerOrder() {
		return customerOrder;
	}

	public void setCustomerOrder(CustomerOrders customerOrder) {
		this.customerOrder = customerOrder;
	}
	

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public CustomerOrderItems(Long itemId, String itemDescription, Long orderQty, String fulfillmentId, String ewayBill,
			String awb, String tpl, String dispatchLocation, String shipmentStatus, CustomerOrders customerOrder) {
		super();
		this.itemId = itemId;
		this.itemDescription = itemDescription;
		this.orderQty = orderQty;
		this.fulfillmentId = fulfillmentId;
		this.ewayBill = ewayBill;
		this.awb = awb;
		this.tpl = tpl;
		this.dispatchLocation = dispatchLocation;
		this.shipmentStatus = shipmentStatus;
		this.customerOrder = customerOrder;
	}

	public CustomerOrderItems() {
		super();
		// TODO Auto-generated constructor stub
	}

}
