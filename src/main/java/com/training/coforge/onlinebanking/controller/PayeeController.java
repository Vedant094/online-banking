package com.training.coforge.onlinebanking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.training.coforge.onlinebanking.model.Payee;
import com.training.coforge.onlinebanking.service.PayeeService;

@RestController
@RequestMapping("/api/payees")
public class PayeeController {

    @Autowired
    private PayeeService payeeService;

    // Add a new payee
    @PostMapping
    public ResponseEntity<Payee> addPayee(@RequestBody Payee payee) {
        Payee savedPayee = payeeService.addPayee(payee);
        return ResponseEntity.ok(savedPayee);
    }

    // Get all payees
    @GetMapping
    public ResponseEntity<List<Payee>> getAllPayees() {
        List<Payee> payees = payeeService.getAllPayees();
        return ResponseEntity.ok(payees);
    }

    // Get payees by user ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Payee>> getPayeesByUser(@PathVariable Long userId) {
        List<Payee> payees = payeeService.getPayeesByUserId(userId);
        return ResponseEntity.ok(payees);
    }

    // Get a payee by ID
    @GetMapping("/{payeeId}")
    public ResponseEntity<Payee> getPayeeById(@PathVariable Long payeeId) {
        return payeeService.getPayeeById(payeeId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a payee
    @DeleteMapping("/{payeeId}")
    public ResponseEntity<Void> deletePayee(@PathVariable Long payeeId) {
        payeeService.deletePayee(payeeId);
        return ResponseEntity.noContent().build();
    }

    // Find payee by account number
    @GetMapping("/account/{accountNumber}")
    public ResponseEntity<Payee> getPayeeByAccountNumber(@PathVariable String accountNumber) {
        Payee payee = payeeService.findByAccountNumber(accountNumber);
        if (payee != null) {
            return ResponseEntity.ok(payee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
