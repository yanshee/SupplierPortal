package com.supplierportal.poasn.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supplierportal.poasn.Dto.CustomerOrderItemsDto;
import com.supplierportal.poasn.Dto.ItemInformationDto;
import com.supplierportal.poasn.entity.CustomerOrders;
import com.supplierportal.poasn.entity.CustomerOrderItems;
import com.supplierportal.poasn.entity.ItemInformation;
import com.supplierportal.poasn.repository.CustomerOrderItemsRepository;
import com.supplierportal.poasn.repository.CustomerOrdersRepository;
import com.supplierportal.poasn.service.CustomerOrderItemsService;

@Service
public class CustomerOrderItemsServiceImpl implements CustomerOrderItemsService {
	
	@Autowired
	private CustomerOrdersRepository customRepo;
	
	@Autowired
	private CustomerOrderItemsRepository customorderitemRepo;
	

	@Override
	public CustomerOrderItemsDto createItem(CustomerOrderItemsDto customerorderItems) {
		Long id=customerorderItems.getOrderId();
		CustomerOrders customorder=customRepo.getById(id);
		
		CustomerOrderItems items=new CustomerOrderItems(customerorderItems.getItemId(),
				customerorderItems.getItemDescription(),
				customerorderItems.getOrderQty(),
				customerorderItems.getFulfillmentId(),
				customerorderItems.getEwayBill(),
				customerorderItems.getAwb(),
				customerorderItems.getTpl(),
				customerorderItems.getDispatchLocation(),
				customerorderItems.getShipmentStatus(),
				customorder);

		CustomerOrderItems  saveditems=customorderitemRepo.save(items);
		     
		//convert JPA entity to  DTO
		CustomerOrderItemsDto savedorderDto=new CustomerOrderItemsDto(saveditems.getItemId(),
				saveditems.getItemDescription(),
				saveditems.getOrderQty(),
				saveditems.getFulfillmentId(),
				saveditems.getEwayBill(),
				saveditems.getAwb(),
				saveditems.getTpl(),
				saveditems.getDispatchLocation(),
				saveditems.getShipmentStatus(),
				id);
		    
		     return savedorderDto;
	}
	
	@Override
	 public void remove(Long id){
		 customorderitemRepo.deleteById(id);
	    }
	
	@Override
	public List<CustomerOrderItems> findAll(){
        return customorderitemRepo.findAll();
    }

	
}
