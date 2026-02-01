package com.aymen.householdmangsyst.controller;

import com.aymen.householdmangsyst.entity.Budget;
import com.aymen.householdmangsyst.repository.BudgetRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/budgets")
public class BudgetController {

    private final BudgetRepository budgetRepository;

    public BudgetController(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    @GetMapping
    public List<Budget> getAllBudgets() {
        return budgetRepository.findAll();
    }

    @PostMapping
    public Budget createBudget(@RequestBody Budget budget) {
        return budgetRepository.save(budget);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Budget> updateBudget(@PathVariable Long id, @RequestBody Budget budgetDetails) {
        return budgetRepository.findById(id)
                .map(budget -> {
                    budget.setCategory(budgetDetails.getCategory());
                    budget.setAmountLimit(budgetDetails.getAmountLimit());
                    budget.setMonth(budgetDetails.getMonth());
                    return ResponseEntity.ok(budgetRepository.save(budget));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBudget(@PathVariable Long id) {
        budgetRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}