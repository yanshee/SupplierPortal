package com.supplierportal.poasn.Dto;

public class poItemDto {
	
	private long itemid;
	private String itemNumber;
	private String itemName;
	private Integer orderedQty;
	private Integer shippedQty;
	private Integer deliveredQty;
	private String estdLandingCost;
	private Long poId;
	private Integer serialid;
	
	
	public long getItemid() {
		return itemid;
	}

	public void setItemid(long itemid) {
		this.itemid = itemid;
	}

	public String getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getOrderedQty() {
		return orderedQty;
	}

	public void setOrderedQty(int orderedQty) {
		this.orderedQty = orderedQty;
	}
	

	public void setOrderedQty(Integer orderedQty) {
		this.orderedQty = orderedQty;
	}
	
	public Integer getSerialid() {
		return serialid;
	}

	public void setSerialid(Integer serialid) {
		this.serialid = serialid;
	}

	public Long getPoId() {
		return poId;
	}

	public void setPoId(Long poId) {
		this.poId = poId;
	}
	
	public Integer getShippedQty() {
		return shippedQty;
	}

	public void setShippedQty(Integer shippedQty) {
		this.shippedQty = shippedQty;
	}

	public Integer getDeliveredQty() {
		return deliveredQty;
	}

	public void setDeliveredQty(Integer deliveredQty) {
		this.deliveredQty = deliveredQty;
	}

	public String getEstdLandingCost() {
		return estdLandingCost;
	}

	public void setEstdLandingCost(String estdLandingCost) {
		this.estdLandingCost = estdLandingCost;
	}

	public poItemDto(long itemid, String itemNumber, String itemName, Integer orderedQty,Integer shippedQty,Integer deliveredQty,String estdLandingCost, Long poId, Integer serialid) {
		super();
		this.itemid = itemid;
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.orderedQty = orderedQty;
		this.shippedQty=shippedQty;
		this.deliveredQty=deliveredQty;
		this.estdLandingCost=estdLandingCost;
		this.poId = poId;
		this.serialid = serialid;
	}

	public poItemDto() {
		super();
		// TODO Auto-generated constructor stub
	}	
}
