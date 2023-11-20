package com.supplierportal.poasn.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supplierportal.poasn.Dto.CustomerOrdersDto;
import com.supplierportal.poasn.Dto.ItemInformationDto;
import com.supplierportal.poasn.entity.CustomerOrderItems;
import com.supplierportal.poasn.entity.CustomerOrders;
import com.supplierportal.poasn.entity.ItemInformation;
import com.supplierportal.poasn.repository.CustomerOrdersRepository;
import com.supplierportal.poasn.service.CustomerOrdersService;

@Service
public class CustomerOrdersServiceImpl implements CustomerOrdersService {
	
	@Autowired
	private CustomerOrdersRepository customerOrderRepo;

	@Override
	public CustomerOrdersDto createOrder(CustomerOrdersDto customerorderDto) {
		CustomerOrders order=new CustomerOrders(customerorderDto.getOrderId(),
				customerorderDto.getCustomName(), 
				customerorderDto.getCustomMobile(),
		        customerorderDto.getDeliveryType(),
				customerorderDto.getOrderDate(),
				customerorderDto.getExpdeliveryDate(),
				customerorderDto.getExpdeliveryTime(),
				customerorderDto.getStatus(),
				customerorderDto.getShippingAddress());
		
		CustomerOrders savedorder=customerOrderRepo.save(order);

		        CustomerOrdersDto saveorderDto=new CustomerOrdersDto(savedorder.getOrderId(),
		        		savedorder.getCustomName(),
		        		savedorder.getCustomMobile(),
		        		savedorder.getDeliveryType(),
		        		savedorder.getOrderDate(),
		        		savedorder.getExpdeliveryDate(),
		        		savedorder.getExpdeliveryTime(),
		        		savedorder.getStatus(),
		        		savedorder.getShippingAddress());
		    
		     return saveorderDto;
	}
	
	@Override
	public List<CustomerOrders> findAllInprogress(String status) {
		// TODO Auto-generated method stub
		return customerOrderRepo.findAllByStatus(status);
	}

	

}
