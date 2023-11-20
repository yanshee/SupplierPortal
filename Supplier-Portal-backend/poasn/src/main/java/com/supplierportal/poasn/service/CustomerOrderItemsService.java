package com.supplierportal.poasn.service;

import java.util.List;

import com.supplierportal.poasn.Dto.CustomerOrderItemsDto;
import com.supplierportal.poasn.entity.CustomerOrderItems;

public interface CustomerOrderItemsService {

	CustomerOrderItemsDto createItem(CustomerOrderItemsDto customerorderItems);
	public void remove(Long id);
	 List<CustomerOrderItems> findAll();
	
}
