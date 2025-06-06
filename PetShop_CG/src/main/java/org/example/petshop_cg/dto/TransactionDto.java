package org.example.petshop_cg.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {

    private int transactionId;
    private Integer customerId;
    private Integer petId;
    private LocalDate transactionDate;
    private BigDecimal amount;
    private String transactionStatus;
}
