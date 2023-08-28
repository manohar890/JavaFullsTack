package com.wipro.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.bank.Model.TransactionHistory;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionHistory, Long>{

}
