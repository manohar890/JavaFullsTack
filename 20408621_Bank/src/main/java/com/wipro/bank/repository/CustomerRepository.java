package com.wipro.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.bank.Model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
