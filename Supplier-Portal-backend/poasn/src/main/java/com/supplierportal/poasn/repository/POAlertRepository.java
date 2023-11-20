package com.supplierportal.poasn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supplierportal.poasn.entity.AsnAlert;
import com.supplierportal.poasn.entity.POAlert;

public interface POAlertRepository extends JpaRepository<POAlert, String> {

}
