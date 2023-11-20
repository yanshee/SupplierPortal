package com.supplierportal.poasn.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.supplierportal.poasn.entity.CustomerOrderItems;
import com.supplierportal.poasn.entity.ItemInformation;
import jakarta.transaction.Transactional;


public interface ItemInformationRepository extends JpaRepository<ItemInformation, Integer>{
//	@Modifying
//	@Transactional
//	@Query("delete from purchaseorderasn.item_information where id in(:integers)")
//	void deleteByIdIn(String query);
	
//	@Modifying
//	@Transactional
//	@Query("update item_information i set i.specification=:specification,i.sku=:sku, i.status=status,i.category=category WHERE i.id=:id")
//	void updateMultipleItemsById(@Param("id") Integer id,@Param("specification") String specification, @Param("sku") String sku, @Param("status") String status,@Param("category") String category);
	
	ItemInformation searchById(Integer id);
	
	Optional<ItemInformation> findById(Integer id);
		
	ItemInformation searchByItemBarcode(String itemBarcode);
	
	@Override
	@Query("select e from ItemInformation e where e.deleted = false")
	public List<ItemInformation> findAll();
	
	
	@Override
	@Query("update ItemInformation e set e.deleted =true where e.id = ?1")
	@Modifying
	public void deleteById(Integer id);

		
		
}
