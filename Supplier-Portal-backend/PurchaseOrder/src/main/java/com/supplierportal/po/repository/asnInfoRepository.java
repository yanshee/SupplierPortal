package com.supplierportal.po.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supplierportal.po.entity.asnInfo;

public interface asnInfoRepository extends JpaRepository<asnInfo, String> {

	List<asnInfo> findAll();

}
