package com.supplierportal.poasn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supplierportal.poasn.entity.CustomerOrderItems;
import com.supplierportal.poasn.entity.CustomerOrders;

public interface CustomerOrdersRepository extends JpaRepository<CustomerOrders, Long>{
	
//	CustomerOrders serachByOrderId(Long id);
	
	public List<CustomerOrders> findAllByStatus(String status);

}
