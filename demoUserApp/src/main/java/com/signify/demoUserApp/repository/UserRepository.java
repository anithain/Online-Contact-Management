package com.signify.demoUserApp.repository;


import com.signify.demoUserApp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Customer,Long> {
}
