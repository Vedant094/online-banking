package com.training.coforge.onlinebanking.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "transaction_seq")
    @SequenceGenerator(name = "transaction_seq", initialValue = 1000, allocationSize = 1)
    private Long transactionId;

    // Relationship with Account
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Account account;

    @Column(nullable = false)
    private String beneficiaryAccountNumber;

    @Column(nullable = false)
    private String mode; // e.g., NEFT, IMPS, RTGS

    @Column(nullable = false)
    private Double amount;

    @CreationTimestamp
    @Column(name = "transaction_time", updatable = false)
    private LocalDateTime transactionTime;

    @Column(nullable = false)
    private String status; // e.g., SUCCESS, FAILED, PENDING

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
