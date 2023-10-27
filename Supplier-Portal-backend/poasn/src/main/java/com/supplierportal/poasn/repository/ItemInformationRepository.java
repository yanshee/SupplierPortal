package com.supplierportal.poasn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supplierportal.poasn.entity.ItemInformation;
import com.supplierportal.poasn.entity.pOrder;
import com.supplierportal.poasn.entity.poItem;


public interface ItemInformationRepository extends JpaRepository<ItemInformation, Integer>{
		ItemInformation searchById(Integer id);
}
