package com.aymen.householdmangsyst.controller;

import com.aymen.householdmangsyst.entity.Budget;
import com.aymen.householdmangsyst.entity.Transaction;
import com.aymen.householdmangsyst.repository.BudgetRepository;
import com.aymen.householdmangsyst.repository.TransactionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ai")
public class AiRecommendationController {

    private final BudgetRepository budgetRepository;
    private final TransactionRepository transactionRepository;

    public AiRecommendationController(BudgetRepository budgetRepository, TransactionRepository transactionRepository) {
        this.budgetRepository = budgetRepository;
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("/recommendations/{householdId}")
    public String getAiAdvice(@PathVariable String householdId) {
        // 1. Récupérer les données réelles
        List<Budget> budgets = budgetRepository.findAll();
        List<Transaction> transactions = transactionRepository.findAll();

        // 2. Préparer le "Prompt" pour l'IA
        String prompt = "En tant qu'expert financier, analyse ces données : "
                + "Budgets: " + budgets.toString()
                + " Transactions: " + transactions.toString()
                + ". Donne-moi 3 conseils pour économiser ce mois-ci.";

        // 3. Appeler le service LLM (Gemini, OpenAI, ou local)
        // Pour l'instant, on retourne une simulation
        return "Analyse de l'IA pour le foyer " + householdId + " : " +
                "\n1. Vous avez dépassé votre budget Nourriture de 15%." +
                "\n2. Réduisez vos abonnements inutiles détectés dans vos transactions." +
                "\n3. Proposez un défi d'économie à votre famille ce week-end !";
    }
}