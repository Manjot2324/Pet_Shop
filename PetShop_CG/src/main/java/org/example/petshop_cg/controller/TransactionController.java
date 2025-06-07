
package org.example.petshop_cg.controller;

import org.example.petshop_cg.dto.TransactionDto;
import org.example.petshop_cg.entity.Transaction;
import org.example.petshop_cg.repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionRepo transactionRepo;

    @Autowired
    public TransactionController(TransactionRepo transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    @GetMapping
    public ResponseEntity<List<TransactionDto>> getAllTransactions() {
        List<TransactionDto> transactions = transactionRepo.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDto> getTransactionById(@PathVariable int id) {
        return transactionRepo.findById(id)
                .map(this::mapToDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    private TransactionDto mapToDto(Transaction t) {
        Integer customerId = (t.getCustomer() != null) ? t.getCustomer().getCustomer_id() : null;
        Integer petId = (t.getPet() != null) ? t.getPet().getPetId() : null;
        String status = (t.getTransactionStatus() != null) ? t.getTransactionStatus().name() : null;

        return new TransactionDto(
                t.getTransactionId(),
                customerId,
                petId,
                t.getTransactionDate(),
                t.getAmount(),
                status
        );
    }
}

