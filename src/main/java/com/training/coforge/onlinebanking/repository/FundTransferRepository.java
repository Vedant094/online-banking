package com.training.coforge.onlinebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.coforge.onlinebanking.model.FundTransfer;

@Repository
public interface FundTransferRepository extends JpaRepository<FundTransfer, Long> {

    // Example custom query methods you might need later:
    // List<FundTransfer> findByFromAccountAccountNumber(String accountNumber);
    // List<FundTransfer> findByToAccountAccountNumber(String accountNumber);

}
