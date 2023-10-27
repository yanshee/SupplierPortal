package com.supplierportal.po.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.supplierportal.po.entity.itemDetails;
import com.supplierportal.po.entity.purchaseOrder;

public interface itemDetailsRepository extends JpaRepository<itemDetails, String> {
//	@Query("SELECT item FROM itemDetails item WHERE item.itemId= :itemId") 
//	itemDetails searchById(String itemId);

}
