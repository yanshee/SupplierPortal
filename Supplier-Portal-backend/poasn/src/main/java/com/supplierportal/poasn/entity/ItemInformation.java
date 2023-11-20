package com.supplierportal.poasn.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
@SQLDelete(sql = "UPDATE CustomerOrderItems SET deleted = true WHERE itemId=?")
@Where(clause = "deleted=false")
public class ItemInformation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String specification;
	private String processorName;
	private String itemBarcode;
	private String sku;
	private String price;
	private String newPrice;
	private String category;
	private String status;
	private boolean deleted = Boolean.FALSE;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="itemid", referencedColumnName="itemid")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private poItem item;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getItemBarcode() {
		return itemBarcode;
	}

	public void setItemBarcode(String itemBarcode) {
		this.itemBarcode = itemBarcode;
	}

	public poItem getItem() {
		return item;
	}

	public void setItem(poItem item) {
		this.item = item;
	}
	
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(String newPrice) {
		this.newPrice = newPrice;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public ItemInformation(Integer id, String specification, String processorName, String itemBarcode, String sku,
			String price, String category, String status, poItem item) {
		super();
		this.id = id;
		this.specification = specification;
		this.processorName = processorName;
		this.itemBarcode = itemBarcode;
		this.sku = sku;
		this.price = price;
		this.category = category;
		this.status = status;
		this.item = item;
	}
	
	public ItemInformation(String specification, String processorName, String itemBarcode, String sku, String price,
			String category, String status, poItem item) {
		super();
		this.specification = specification;
		this.processorName = processorName;
		this.itemBarcode = itemBarcode;
		this.sku = sku;
		this.price = price;
		this.category = category;
		this.status = status;
		this.item = item;
	}
	
	public ItemInformation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
