package com.supplierportal.po.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.supplierportal.po.entity.*;


public interface purchaseOrderRepository extends JpaRepository<purchaseOrder, String>{

	@Query("SELECT po FROM purchaseOrder po WHERE po.poId= :poId") 
	purchaseOrder searchById(String poId);
	
	@Query("SELECT po FROM purchaseOrder po WHERE " +
			"po.location LIKE CONCAT('%',:query, '%')" +
            "or po.creationDate LIKE CONCAT('%',:query, '%')")
	List<purchaseOrder> filterProducts(String query);
	
}
