package com.supplierportal.poasn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supplierportal.poasn.entity.Asn;
import com.supplierportal.poasn.entity.AsnInformation;
import com.supplierportal.poasn.entity.pOrder;


public interface AsnInformationRepository extends JpaRepository<AsnInformation, Integer>{
   AsnInformation searchBySerialid(Integer serialid);
}
