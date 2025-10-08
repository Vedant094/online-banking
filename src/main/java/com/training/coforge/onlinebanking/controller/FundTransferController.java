package com.training.coforge.onlinebanking.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.training.coforge.onlinebanking.model.FundTransfer;
import com.training.coforge.onlinebanking.service.FundTransferService;

@RestController
@RequestMapping("/api/fundtransfers")
public class FundTransferController {

    @Autowired
    private FundTransferService fundTransferService;

    // Create a new fund transfer
    @PostMapping
    public ResponseEntity<FundTransfer> createFundTransfer(@RequestBody FundTransfer fundTransfer) {
        FundTransfer savedTransfer = fundTransferService.createFundTransfer(fundTransfer);
        return ResponseEntity.ok(savedTransfer);
    }

    // Get all fund transfers
    @GetMapping
    public ResponseEntity<List<FundTransfer>> getAllFundTransfers() {
        List<FundTransfer> transfers = fundTransferService.getAllFundTransfers();
        return ResponseEntity.ok(transfers);
    }

    // Get fund transfer by ID
    @GetMapping("/{id}")
    public ResponseEntity<FundTransfer> getFundTransferById(@PathVariable Long id) {
        Optional<FundTransfer> transfer = fundTransferService.getFundTransferById(id);
        return transfer.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }

    // Delete a fund transfer by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFundTransfer(@PathVariable Long id) {
        fundTransferService.deleteFundTransfer(id);
        return ResponseEntity.noContent().build();
    }

}
