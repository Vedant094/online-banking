package com.training.coforge.onlinebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.coforge.onlinebanking.model.Account;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // Find all accounts for a specific user
    List<Account> findByUserUserId(Long userId);

    // Find account by account number
    Account findByAccountNumber(String accountNumber);
}
