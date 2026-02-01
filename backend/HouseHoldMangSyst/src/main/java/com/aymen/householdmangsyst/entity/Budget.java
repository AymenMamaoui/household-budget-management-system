package com.aymen.householdmangsyst.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "budgets")
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;
    private Double amountLimit; // Le plafond à ne pas dépasser
    private Double currentSpending = 0.0; // Ce qui a déjà été dépensé
    private String month;       // Pour filtrer (ex: "2026-01")

    public Budget() {}

    // Getters et Setters
    public Long getId() { return id; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Double getAmountLimit() { return amountLimit; }
    public void setAmountLimit(Double amountLimit) { this.amountLimit = amountLimit; }

    public Double getCurrentSpending() { return currentSpending; }
    public void setCurrentSpending(Double currentSpending) { this.currentSpending = currentSpending; }

    public String getMonth() { return month; }
    public void setMonth(String month) { this.month = month; }
}