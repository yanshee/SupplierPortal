package com.bezkoder.spring.login.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bezkoder.spring.login.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findBySupplierName(String supplierName);

  Boolean existsBySupplierName(String supplierName);

  Boolean existsByEmail(String email);
}
