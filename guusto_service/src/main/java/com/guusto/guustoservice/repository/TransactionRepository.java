package com.guusto.guustoservice.repository;

import com.guusto.guustoservice.model.Client;
import com.guusto.guustoservice.model.GiftCardTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<GiftCardTransaction, Long> {
    List<GiftCardTransaction> findGiftCardTransactionsByClientId(Client client);
}
