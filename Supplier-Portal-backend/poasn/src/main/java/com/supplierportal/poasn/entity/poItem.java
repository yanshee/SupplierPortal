package com.supplierportal.poasn.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class poItem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long itemid;
	private String itemNumber;
	private String itemName;
	private Integer orderedQty;
	private Integer shippedQty;
	private Integer deliveredQty;
	private String estdLandingCost;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="po_id",referencedColumnName="poId")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private pOrder po;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="serialid",referencedColumnName="serialid")
	private AsnInformation asninfo;

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

	public pOrder getPo() {
		return po;
	}

	public void setPo(pOrder po) {
		this.po = po;
	}
	
	public AsnInformation getAsninfo() {
		return asninfo;
	}

	public void setAsninfo(AsnInformation asninfo) {
		this.asninfo = asninfo;
	}

	public void setOrderedQty(Integer orderedQty) {
		this.orderedQty = orderedQty;
	}

	public poItem(long itemid, String itemNumber, String itemName, Integer orderedQty,Integer shippedQty,Integer deliveredQty, String estdLandingCost, pOrder po, AsnInformation asninfo) {
		super();
		this.itemid = itemid;
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.orderedQty = orderedQty;
		this.shippedQty=shippedQty;
		this.deliveredQty=deliveredQty;
		this.estdLandingCost=estdLandingCost;
		this.po = po;
		this.asninfo = asninfo;
	}

	public poItem() {
		super();
		// TODO Auto-generated constructor stub
	}	
}
