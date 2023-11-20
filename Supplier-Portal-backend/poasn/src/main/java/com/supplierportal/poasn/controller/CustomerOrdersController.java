package com.supplierportal.poasn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supplierportal.poasn.Dto.CustomerOrderItemsDto;
import com.supplierportal.poasn.Dto.CustomerOrdersDto;
import com.supplierportal.poasn.Dto.pOrderDto;
import com.supplierportal.poasn.entity.CustomerOrderItems;
import com.supplierportal.poasn.entity.CustomerOrders;
import com.supplierportal.poasn.entity.pOrder;
import com.supplierportal.poasn.service.CustomerOrderItemsService;
import com.supplierportal.poasn.service.CustomerOrdersService;

@RestController
@RequestMapping("/customerorder")
public class CustomerOrdersController {
	
	@Autowired
	private CustomerOrdersService customerorderService;
	
	@Autowired
	private CustomerOrderItemsService customerorderitemService;
	
	@PostMapping("/createCustomOrder")
	public ResponseEntity<CustomerOrdersDto> createCustomerOrders(@RequestBody CustomerOrdersDto order){
		CustomerOrdersDto savedorder=customerorderService.createOrder(order);
		return new ResponseEntity<>(savedorder,HttpStatus.CREATED);	
	}
	
	
	@PostMapping("/createCustomOrderItems")
	public ResponseEntity<CustomerOrderItemsDto> createOrderItems(@RequestBody CustomerOrderItemsDto orderitems){
		CustomerOrderItemsDto savedorder=customerorderitemService.createItem(orderitems);
		return new ResponseEntity<>(savedorder,HttpStatus.CREATED);	
	}
	
	@GetMapping("/display/order")
    public ResponseEntity<List<CustomerOrderItems>> displayallOrders(){
		List<CustomerOrderItems> allPO=customerorderitemService.findAll();
		return new ResponseEntity<>(allPO,HttpStatus.CREATED);   
   }
	
	 @DeleteMapping("delete/{id}")
    public void deleteItem(@PathVariable Long id){
    	 customerorderitemService.remove(id);
    }
	
	 @GetMapping("/displayInprogress/{status}")
	    public ResponseEntity<List<CustomerOrders>> displayallInprogress(@PathVariable String status){
			List<CustomerOrders> allInprogress=customerorderService.findAllInprogress(status);
			return new ResponseEntity<>(allInprogress,HttpStatus.CREATED);   
	   }

}
