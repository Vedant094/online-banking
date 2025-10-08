package com.training.coforge.onlinebanking.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.coforge.onlinebanking.model.Account;
import com.training.coforge.onlinebanking.model.FundTransfer;
import com.training.coforge.onlinebanking.repository.AccountRepository;
import com.training.coforge.onlinebanking.repository.FundTransferRepository;

@Service
public class FundTransferService {

    @Autowired
    private FundTransferRepository fundTransferRepository;

    @Autowired
    private AccountRepository accountRepository;
    
    //create a new fund transfer
    public FundTransfer createFundTransfer(FundTransfer fundTransfer) {

        // Fetch full accounts from DB
        Account fromAccount = accountRepository.findById(fundTransfer.getFromAccount().getAccountId())
                .orElseThrow(() -> new RuntimeException("From Account not found"));
        Account toAccount = accountRepository.findById(fundTransfer.getToAccount().getAccountId())
                .orElseThrow(() -> new RuntimeException("To Account not found"));

        // Deduct and credit balances
        if (fromAccount.getBalance() < fundTransfer.getAmount()) {
            throw new RuntimeException("Insufficient balance");
        }
        fromAccount.setBalance(fromAccount.getBalance() - fundTransfer.getAmount());
        toAccount.setBalance(toAccount.getBalance() + fundTransfer.getAmount());

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        // Set the fully loaded accounts in FundTransfer
        fundTransfer.setFromAccount(fromAccount);
        fundTransfer.setToAccount(toAccount);

        // Set defaults if missing
        if (fundTransfer.getTransferDate() == null) fundTransfer.setTransferDate(LocalDate.now());
        if (fundTransfer.getStatus() == null) fundTransfer.setStatus("SUCCESS");
        fundTransfer.setUpdatedAt(LocalDate.now());

        return fundTransferRepository.save(fundTransfer);
    }

    // Get all fund transfers
    public List<FundTransfer> getAllFundTransfers() {
        return fundTransferRepository.findAll();
    }

    // Get fund transfer by ID
    public Optional<FundTransfer> getFundTransferById(Long id) {
        return fundTransferRepository.findById(id);
    }

    // Delete fund transfer by ID
    public void deleteFundTransfer(Long id) {
        fundTransferRepository.deleteById(id);
    }

    // Optional: Add custom methods if needed in future
    // Example: Get all fund transfers for a specific account
    // public List<FundTransfer> getTransfersByFromAccount(String accountNumber) {
    //     return fundTransferRepository.findByFromAccountAccountNumber(accountNumber);
    // }

}
