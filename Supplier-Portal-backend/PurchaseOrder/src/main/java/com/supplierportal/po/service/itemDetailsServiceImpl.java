package com.supplierportal.po.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supplierportal.po.dto.itemDetailsDto;
import com.supplierportal.po.dto.purchaseOrderDto;
import com.supplierportal.po.entity.itemDetails;
import com.supplierportal.po.entity.purchaseOrder;
import com.supplierportal.po.repository.itemDetailsRepository;

@Service
public class itemDetailsServiceImpl implements itemDetailsService{
	
	@Autowired
	private itemDetailsRepository itemdetailsRepository;
	

	@Override
	public List<itemDetails> listAll() {
		return itemdetailsRepository.findAll();
	}
	
//	@Override
//	public itemDetails searchById(String itemId) {
//		// TODO Auto-generated method stub
//		itemDetails item = itemdetailsRepository.searchById(itemId);
//        return item;
//	}



	@Override
	public itemDetailsDto createitemDetails(itemDetailsDto itemdetailsDto) {
		// TODO Auto-generated method stub
		itemDetails item=new itemDetails(itemdetailsDto.getItemId(), 
				itemdetailsDto.getItemName(),
				itemdetailsDto.getOrderQty(),
				itemdetailsDto.getShipQty(),
				itemdetailsDto.getDeliverQty(),
				itemdetailsDto.getEstCost(),
				itemdetailsDto.getSpecification(),
				itemdetailsDto.getProcessorName(),
				itemdetailsDto.getBarCode());

		     itemDetails saveditems=itemdetailsRepository.save(item);

		//convert JPA entity to  DTO
		     itemDetailsDto saveditemDto=new itemDetailsDto(saveditems.getItemId(),
		    		 saveditems.getItemName(),
		    		 saveditems.getOrderQty(),
		    		 saveditems.getShipQty(),
		    		 saveditems.getDeliverQty(),
		    		 saveditems.getEstCost(),
		    		 saveditems.getSpecification(),
		    		 saveditems.getProcessorName(),
		    		 saveditems.getBarCode());
		    
		     return saveditemDto;
	}

}
