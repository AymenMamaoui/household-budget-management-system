package com.aymen.householdmangsyst.controller;

import com.aymen.householdmangsyst.entity.Budget;
import com.aymen.householdmangsyst.entity.Transaction;
import com.aymen.householdmangsyst.repository.BudgetRepository;
import com.aymen.householdmangsyst.repository.TransactionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionRepository transactionRepository;
    private final BudgetRepository budgetRepository;

    public TransactionController(TransactionRepository transactionRepository, BudgetRepository budgetRepository) {
        this.transactionRepository = transactionRepository;
        this.budgetRepository = budgetRepository;
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        // 1. Sauvegarder la transaction
        Transaction savedTransaction = transactionRepository.save(transaction);

        // 2. Mettre à jour le montant dépensé dans le budget correspondant
        if (transaction.getBudget() != null) {
            Budget budget = budgetRepository.findById(transaction.getBudget().getId()).orElseThrow();
            budget.setCurrentSpending(budget.getCurrentSpending() + transaction.getAmount());
            budgetRepository.save(budget);
        }

        return savedTransaction;
    }
}