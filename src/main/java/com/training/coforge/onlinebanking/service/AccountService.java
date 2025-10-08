package com.training.coforge.onlinebanking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.coforge.onlinebanking.model.Account;
//import com.training.coforge.onlinebanking.model.User;
import com.training.coforge.onlinebanking.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    // Create a new account
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    // Get all accounts
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    // Get account by ID
    public Optional<Account> getAccountById(Long accountId) {
        return accountRepository.findById(accountId);
    }

    // Get accounts for a specific user
    public List<Account> getAccountsByUserId(Long userId) {
        return accountRepository.findByUserUserId(userId);
    }

    // Delete an account
    public void deleteAccount(Long accountId) {
        accountRepository.deleteById(accountId);
    }

    // Update balance (used for fund transfer or deposits/withdrawals)
    @Transactional
    public Account updateBalance(Long accountId, Double newBalance) {
        Optional<Account> optAccount = accountRepository.findById(accountId);
        if (optAccount.isPresent()) {
            Account account = optAccount.get();
            account.setBalance(newBalance);
            return accountRepository.save(account);
        }
        return null;
    }
}
