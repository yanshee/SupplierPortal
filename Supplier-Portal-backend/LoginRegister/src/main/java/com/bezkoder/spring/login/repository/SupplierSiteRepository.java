package com.bezkoder.spring.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.login.models.SupplierSite;


public interface SupplierSiteRepository extends JpaRepository<SupplierSite, Integer>{
	SupplierSite findBySiteName(String siteName);

}
