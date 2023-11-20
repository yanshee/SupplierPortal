package com.supplierportal.poasn.service;

import java.util.List;

import com.supplierportal.poasn.Dto.pOrderDto;
import com.supplierportal.poasn.entity.pOrder;



public interface pOrderService {
	List<pOrder> listAll();
	List<pOrder> findPurchaseOrderWithSorting(String field) ;
	pOrderDto createPurchaseOrder(pOrderDto purchaseorderDto); 
	pOrder searchById(Long poId);
//	List<pOrder> filterProducts(String query);
	
}
