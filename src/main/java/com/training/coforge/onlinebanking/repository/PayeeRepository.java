package com.training.coforge.onlinebanking.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.training.coforge.onlinebanking.model.Payee;

@Repository
public interface PayeeRepository extends JpaRepository<Payee, Long> {

    // Custom query methods if needed
    List<Payee> findByUserUserId(Long userId); // Get all payees for a specific user
    Payee findByAccountNumber(String accountNumber); // Get a payee by their account number
}
