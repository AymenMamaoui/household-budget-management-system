package com.aymen.householdmangsyst.repository;

import com.aymen.householdmangsyst.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // Pour retrouver les transactions d'un utilisateur spécifique
    List<Transaction> findByUserId(Long userId);
}