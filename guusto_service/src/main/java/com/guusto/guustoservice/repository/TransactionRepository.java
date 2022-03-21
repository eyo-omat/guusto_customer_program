package com.guusto.guustoservice.repository;

import com.guusto.guustoservice.model.GiftCardTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<GiftCardTransaction, Long> {
}
