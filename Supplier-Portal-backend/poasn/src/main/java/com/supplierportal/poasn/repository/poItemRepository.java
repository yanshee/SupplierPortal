package com.supplierportal.poasn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supplierportal.poasn.entity.poItem;


public interface poItemRepository extends JpaRepository<poItem, Long>{
	poItem searchByItemid(Long itemid);


}
