package com.supplierportal.po.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.supplierportal.po.dto.purchaseOrderDto;
import com.supplierportal.po.entity.itemDetails;
import com.supplierportal.po.entity.purchaseOrder;
import com.supplierportal.po.repository.itemDetailsRepository;
import com.supplierportal.po.repository.purchaseOrderRepository;

@Service
public class purchaseOrderServiceImpl implements purchaseOrderService{
	
	@Autowired
	private purchaseOrderRepository purchaseOrderRepository;
	
	
	public purchaseOrderServiceImpl(purchaseOrderRepository purchaseOrderRepository) {
		super();
		this.purchaseOrderRepository = purchaseOrderRepository;
	}
	

	@Override
	public List<purchaseOrder> listAll() {
		// TODO Auto-generated method stub
		return purchaseOrderRepository.findAll();
	}

	@Override
	public List<purchaseOrder> findPurchaseOrderWithSorting(String field) {
		return purchaseOrderRepository.findAll(Sort.by(Sort.Direction.ASC, field));
	}

	@Override
	public purchaseOrderDto createPurchaseOrder(purchaseOrderDto purchaseorderDto) {
		purchaseOrder purchaseorder=new purchaseOrder(purchaseorderDto.getPoId(), 
		purchaseorderDto.getLocation(),
        purchaseorderDto.getCreationDate(),
		purchaseorderDto.getShipByDate(),
		purchaseorderDto.getEstimatedDeliveryDate(),
        purchaseorderDto.getPoQty(),
        purchaseorderDto.getLeadTime(),
        purchaseorderDto.getTotalItems(),
        purchaseorderDto.getTotalCost(),
        purchaseorderDto.getPercentcost());

     purchaseOrder savedpurchaseorder=purchaseOrderRepository.save(purchaseorder);

//convert JPA entity to  DTO
     purchaseOrderDto savedpurchaseDto=new purchaseOrderDto(savedpurchaseorder.getPoId(),
    		 savedpurchaseorder.getLocation(),
    		 savedpurchaseorder.getCreationDate(),
    		 savedpurchaseorder.getShipByDate(),
    		 savedpurchaseorder.getEstimatedDeliveryDate(),
    		 savedpurchaseorder.getPoQty(),
    		 savedpurchaseorder.getLeadTime(),
    		 savedpurchaseorder.getTotalItems(),
    		 savedpurchaseorder.getTotalCost(),
    		 savedpurchaseorder.getPercentcost());
    
     return savedpurchaseDto;

}

	@Override
	public purchaseOrder searchById(String poId) {
		// TODO Auto-generated method stub
		purchaseOrder product = purchaseOrderRepository.searchById(poId);
        return product;
	}

	@Override
	public List<purchaseOrder> filterProducts(String query) {
		// TODO Auto-generated method stub
		List<purchaseOrder> products = purchaseOrderRepository.filterProducts(query);
        return products;
	}

	

	

	

	
}
