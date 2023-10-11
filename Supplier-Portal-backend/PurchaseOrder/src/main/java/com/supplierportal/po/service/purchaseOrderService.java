package com.supplierportal.po.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supplierportal.po.dto.purchaseOrderDto;
import com.supplierportal.po.entity.purchaseOrder;
import com.supplierportal.po.repository.purchaseOrderRepository;


public interface purchaseOrderService {
	
	List<purchaseOrder> listAll();
	List<purchaseOrder> findPurchaseOrderWithSorting(String field) ;
	purchaseOrderDto createPurchaseOrder(purchaseOrderDto purchaseorderDto); 
	purchaseOrder searchById(String poId);
	List<purchaseOrder> filterProducts(String query);
}
