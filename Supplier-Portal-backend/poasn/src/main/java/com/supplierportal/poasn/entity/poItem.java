package com.supplierportal.poasn.entity;

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
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="po_id",referencedColumnName="poId")
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

	public poItem(long itemid, String itemNumber, String itemName, Integer orderedQty, pOrder po, AsnInformation asninfo) {
		super();
		this.itemid = itemid;
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.orderedQty = orderedQty;
		this.po = po;
		this.asninfo = asninfo;
	}

	public poItem() {
		super();
		// TODO Auto-generated constructor stub
	}	
}
