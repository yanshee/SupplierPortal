package com.supplierportal.po.dto;

public class asnInfoDto {

	private String itemId;
	private String items;
	private String poQty;
	private String deliveredQty;
	private String shippedQty;
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public String getPoQty() {
		return poQty;
	}
	public void setPoQty(String poQty) {
		this.poQty = poQty;
	}
	public String getDeliveredQty() {
		return deliveredQty;
	}
	public void setDeliveredQty(String deliveredQty) {
		this.deliveredQty = deliveredQty;
	}
	public String getShippedQty() {
		return shippedQty;
	}
	public void setShippedQty(String shippedQty) {
		this.shippedQty = shippedQty;
	}
	public asnInfoDto(String itemId, String items, String poQty, String deliveredQty, String shippedQty) {
		super();
		this.itemId = itemId;
		this.items = items;
		this.poQty = poQty;
		this.deliveredQty = deliveredQty;
		this.shippedQty = shippedQty;
	}
	public asnInfoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
