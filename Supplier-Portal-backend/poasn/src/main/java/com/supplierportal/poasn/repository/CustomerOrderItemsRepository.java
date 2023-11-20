package com.supplierportal.poasn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.supplierportal.poasn.entity.Asn;
import com.supplierportal.poasn.entity.CustomerOrderItems;
import com.supplierportal.poasn.entity.CustomerOrders;

public interface CustomerOrderItemsRepository extends JpaRepository<CustomerOrderItems, Long>{

	CustomerOrders save(CustomerOrders saveditems);
	
	@Override
	@Query("select e from CustomerOrderItems e where e.deleted = false")
	public List<CustomerOrderItems> findAll();
	
	
	@Override
	@Query("update CustomerOrderItems e set e.deleted =true where e.itemId = ?1")
	@Modifying
	public void deleteById(Long id);
	
	

}
