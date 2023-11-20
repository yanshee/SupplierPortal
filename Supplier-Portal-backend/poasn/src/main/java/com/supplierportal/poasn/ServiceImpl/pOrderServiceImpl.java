package com.supplierportal.poasn.ServiceImpl;

import java.sql.Date;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.supplierportal.poasn.Dto.pOrderDto;
import com.supplierportal.poasn.entity.pOrder;
import com.supplierportal.poasn.repository.pOrderRepository;
import com.supplierportal.poasn.service.pOrderService;

@Service
public class pOrderServiceImpl implements pOrderService{
	
	@Autowired
	private pOrderRepository purchaseOrderRepository;
	
//	public pOrderServiceImpl(pOrderRepository purchaseOrderRepository) {
//		super();
//		this.purchaseOrderRepository = purchaseOrderRepository;
//	}
//	

	@Override
	public List<pOrder> listAll() {
		// TODO Auto-generated method stub
		return purchaseOrderRepository.findAll();
	}

	@Override
	public List<pOrder> findPurchaseOrderWithSorting(String field) {
		return purchaseOrderRepository.findAll(Sort.by(Sort.Direction.ASC, field));
	}

	@Override
	public pOrderDto createPurchaseOrder(pOrderDto purchaseorderDto) {
		pOrder purchaseorder=new pOrder(purchaseorderDto.getPoId(), 
		purchaseorderDto.getLocation(),
        purchaseorderDto.getCreationDate(),
        purchaseorderDto.getPoQty(),
        purchaseorderDto.getTotalItems(),
        purchaseorderDto.getShipDate(),
        purchaseorderDto.getEstDeliveryDate(),
        purchaseorderDto.getSupplierSite(),
        purchaseorderDto.getLeadTime(),
        purchaseorderDto.getTotalCost());

     pOrder savedpurchaseorder=purchaseOrderRepository.save(purchaseorder);

//convert JPA entity to  DTO
     pOrderDto savedpurchaseDto=new pOrderDto(savedpurchaseorder.getPoId(),
    		 savedpurchaseorder.getLocation(),
    		 savedpurchaseorder.getCreationDate(),
    		 savedpurchaseorder.getPoQty(),
    		 savedpurchaseorder.getTotalItems(),
    		 savedpurchaseorder.getShipDate(),
    		 savedpurchaseorder.getEstDeliveryDate(),
    		 savedpurchaseorder.getSupplierSite(),
    		 savedpurchaseorder.getLeadTime(),
    		 savedpurchaseorder.getTotalCost());
    
     return savedpurchaseDto;

}

	@Override
	public pOrder searchById(Long poId) {
		pOrder product = purchaseOrderRepository.searchBypoId(poId);
        return product;
	}

//	@Override
//	public List<purchaseOrder> filterProducts(String query) {
//		// TODO Auto-generated method stub
//		List<purchaseOrder> products = purchaseOrderRepository.filterProducts(query);
//        return products;
//	}
//	
}