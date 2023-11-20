package com.supplierportal.poasn.Dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


public class ItemInformationDto {
	
	private Integer id;
	private String specification;
	private String processorName;
	private String itemBarcode;
	private String sku;
	private String price;
	private String category;
	private String status;
	
	private long itemid;

	
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

	public long getItemid() {
		return itemid;
	}

	public void setItemid(long itemid) {
		this.itemid = itemid;
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

	

	public ItemInformationDto(Integer id, String specification, String processorName, String itemBarcode, String sku,
			String price, String category, String status, long itemid) {
		super();
		this.id = id;
		this.specification = specification;
		this.processorName = processorName;
		this.itemBarcode = itemBarcode;
		this.sku = sku;
		this.price = price;
		this.category = category;
		this.status = status;
		this.itemid = itemid;
	}

	public ItemInformationDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
