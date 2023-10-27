package com.supplierportal.poasn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supplierportal.poasn.entity.Asn;


public interface AsnRepository extends JpaRepository<Asn, Long>{
	Asn searchById(Long id);
}
