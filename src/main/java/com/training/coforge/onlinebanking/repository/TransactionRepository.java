package com.training.coforge.onlinebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.training.coforge.onlinebanking.model.Transaction;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    
    // Optional: Find all transactions for a specific account
    List<Transaction> findByAccountAccountId(Long accountId);
    
    // Optional: Find transactions by status
    List<Transaction> findByStatus(String status);
    
    // Optional: Find transactions above a certain amount
    List<Transaction> findByAmountGreaterThan(double amount);
    
}
