package com.training.coforge.onlinebanking.dto;

import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FundTransferDTO {
    private Long fromAccountId;
    private Long toAccountId;
    private double amount;
    private String transferMode;
    private LocalDate transferDate;
    private String status;
    private String remarks;
}
