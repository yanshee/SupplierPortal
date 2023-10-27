package com.supplierportal.poasn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supplierportal.poasn.entity.Asn;
import com.supplierportal.poasn.entity.pOrder;
import com.supplierportal.poasn.entity.poItem;

public interface pOrderRepository extends JpaRepository<pOrder, Long>{

	pOrder searchBypoId(Long poId);

	Asn save(Asn asn);

	poItem save(poItem item);

}
