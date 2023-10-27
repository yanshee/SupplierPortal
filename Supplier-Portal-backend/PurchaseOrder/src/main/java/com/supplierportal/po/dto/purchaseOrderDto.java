package com.supplierportal.po.dto;

import java.sql.Date;


import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

public class purchaseOrderDto {
		private String poId;
		private String location;
		@JsonFormat(pattern="yyyy-MM-dd")
		private Date creationDate;
		@JsonFormat(pattern="yyyy-MM-dd")
		private Date shipByDate;
		@JsonFormat(pattern="yyyy-MM-dd")
		private Date estimatedDeliveryDate;
		private String poQty;
		private String leadTime;
		private String totalItems;
		private String totalCost;
		private String percentcost;
		
		public String getPoId() {
			// TODO Auto-generated method stub
			return poId;
		}
		
		public void setPoId(String poId) {
			this.poId = poId;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public Date getCreationDate() {
			return creationDate;
		}
		public void setCreationDate(Date creationDate) {
			this.creationDate = creationDate;
		}
		public Date getShipByDate() {
			return shipByDate;
		}
		public void setShipByDate(Date shipByDate) {
			this.shipByDate = shipByDate;
		}
		public Date getEstimatedDeliveryDate() {
			return estimatedDeliveryDate;
		}
		public void setEstimatedDeliveryDate(Date estimatedDeliveryDate) {
			this.estimatedDeliveryDate = estimatedDeliveryDate;
		}
		public String getPoQty() {
			return poQty;
		}
		public void setPoQty(String poQty) {
			this.poQty = poQty;
		}
		public String getLeadTime() {
			return leadTime;
		}
		public void setLeadTime(String leadTime) {
			this.leadTime = leadTime;
		}
		public String getTotalItems() {
			return totalItems;
		}
		public void setTotalItems(String totalItems) {
			this.totalItems = totalItems;
		}
		public String getTotalCost() {
			return totalCost;
		}
		public void setTotalCost(String totalCost) {
			this.totalCost = totalCost;
		}
		public String getPercentcost() {
			return percentcost;
		}
		public void setPercentcost(String percentcost) {
			this.percentcost = percentcost;
		}

		public purchaseOrderDto(String poId, String location, Date creationDate, Date shipByDate,
				Date estimatedDeliveryDate, String poQty, String leadTime, String totalItems, String totalCost,
				String percentcost) {
			super();
			this.poId = poId;
			this.location = location;
			this.creationDate = creationDate;
			this.shipByDate = shipByDate;
			this.estimatedDeliveryDate = estimatedDeliveryDate;
			this.poQty = poQty;
			this.leadTime = leadTime;
			this.totalItems = totalItems;
			this.totalCost = totalCost;
			this.percentcost = percentcost;
		}

		public purchaseOrderDto() {
			super();
			// TODO Auto-generated constructor stub
		}
		
	
}
