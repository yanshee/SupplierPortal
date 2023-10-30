package com.bezkoder.spring.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.login.models.Modules;
import com.bezkoder.spring.login.models.SupplierSite;

public interface ModuleRepository  extends JpaRepository<Modules, Integer>{
	Modules findByModuleName(String modulename);

}
