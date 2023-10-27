package com.supplierportal.po.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class itemDetails {
	@Id
  private String itemId;
  private String itemName;
  private String orderQty;
  private String shipQty;
  private String deliverQty;
  private String estCost;
  private String specification;
  private String processorName;
  private String barCode;
public String getItemId() {
	return itemId;
}
public void setItemId(String itemId) {
	this.itemId = itemId;
}
public String getItemName() {
	return itemName;
}
public void setItemName(String itemName) {
	this.itemName = itemName;
}
public String getOrderQty() {
	return orderQty;
}
public void setOrderQty(String orderQty) {
	this.orderQty = orderQty;
}

public String getShipQty() {
	return shipQty;
}
public void setShipQty(String shipQty) {
	this.shipQty = shipQty;
}
public String getDeliverQty() {
	return deliverQty;
}
public void setDeliverQty(String deliverQty) {
	this.deliverQty = deliverQty;
}
public String getEstCost() {
	return estCost;
}
public void setEstCost(String estCost) {
	this.estCost = estCost;
}
public String getSpecification() {
	return specification;
}
public void setSpecification(String specification) {
	this.specification = specification;
}
public String getProcessorName() {
	return processorName;
}
public void setProcessorName(String processorName) {
	this.processorName = processorName;
}
public String getBarCode() {
	return barCode;
}
public void setBarCode(String barCode) {
	this.barCode = barCode;
}
public itemDetails(String itemId, String itemName, String orderQty, String shipQty, String deliverQty, String estCost,
		String specification, String processorName, String barCode) {
	super();
	this.itemId = itemId;
	this.itemName = itemName;
	this.orderQty = orderQty;
	this.shipQty = shipQty;
	this.deliverQty = deliverQty;
	this.estCost = estCost;
	this.specification = specification;
	this.processorName = processorName;
	this.barCode = barCode;
}
public itemDetails() {
	super();
	// TODO Auto-generated constructor stub
}






  
  
}
