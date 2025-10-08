package com.training.coforge.onlinebanking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.coforge.onlinebanking.model.Payee;
import com.training.coforge.onlinebanking.repository.PayeeRepository;

@Service
public class PayeeService {

    @Autowired
    private PayeeRepository payeeRepository;

    // Add a new payee
    public Payee addPayee(Payee payee) {
        return payeeRepository.save(payee);
    }

    // Get all payees
    public List<Payee> getAllPayees() {
        return payeeRepository.findAll();
    }

    // Get payees by user ID
    public List<Payee> getPayeesByUserId(Long userId) {
        return payeeRepository.findByUserUserId(userId);
    }

    // Get a payee by ID
    public Optional<Payee> getPayeeById(Long payeeId) {
        return payeeRepository.findById(payeeId);
    }

    // Delete a payee
    public void deletePayee(Long payeeId) {
        payeeRepository.deleteById(payeeId);
    }

    // Find a payee by account number
    public Payee findByAccountNumber(String accountNumber) {
        return payeeRepository.findByAccountNumber(accountNumber);
    }
}
