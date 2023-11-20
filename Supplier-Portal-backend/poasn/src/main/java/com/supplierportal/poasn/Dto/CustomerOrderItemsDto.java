package com.supplierportal.poasn.Dto;

public class CustomerOrderItemsDto {

	private Long itemId;
	private String itemDescription;
	private Long orderQty;
	private String fulfillmentId;
	private String ewayBill;
	private String awb;
	private String tpl;
	private String dispatchLocation;
	private String shipmentStatus;
	private Boolean deleted;
	
	private Long orderId;

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

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public CustomerOrderItemsDto(Long itemId, String itemDescription, Long orderQty, String fulfillmentId, String ewayBill,
			String awb, String tpl, String dispatchLocation, String shipmentStatus, Long orderId) {
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
		this.orderId = orderId;
	}

	public CustomerOrderItemsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
