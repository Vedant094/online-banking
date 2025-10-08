package com.training.coforge.onlinebanking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.coforge.onlinebanking.model.Account;
import com.training.coforge.onlinebanking.model.Transaction;
import com.training.coforge.onlinebanking.repository.AccountRepository;
import com.training.coforge.onlinebanking.repository.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    
    @Autowired
    private AccountRepository accountRepository;

    // Create or save a transaction
    public Transaction createTransaction(Transaction transaction) {
        // Fetch full account from DB
        Account account = accountRepository.findById(transaction.getAccount().getAccountId())
            .orElseThrow(() -> new RuntimeException("Account not found"));

        transaction.setAccount(account); // set fully loaded account
        return transactionRepository.save(transaction);
    }

    // Get all transactions
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    // Get transaction by ID
    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

    // Delete transaction by ID
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    // Get all transactions for a specific account
    public List<Transaction> getTransactionsByAccountId(Long accountId) {
        return transactionRepository.findByAccountAccountId(accountId);
    }

    // Get transactions by status
    public List<Transaction> getTransactionsByStatus(String status) {
        return transactionRepository.findByStatus(status);
    }

    // Get transactions above a certain amount
    public List<Transaction> getTransactionsAboveAmount(double amount) {
        return transactionRepository.findByAmountGreaterThan(amount);
    }
}
