package com.supplierportal.poasn.service;

import java.util.List;

import com.supplierportal.poasn.Dto.CustomerOrdersDto;
import com.supplierportal.poasn.entity.CustomerOrderItems;
import com.supplierportal.poasn.entity.CustomerOrders;

public interface CustomerOrdersService {

	public CustomerOrdersDto createOrder(CustomerOrdersDto customerorderDto);
	
	 List<CustomerOrders> findAllInprogress(String status);
}
