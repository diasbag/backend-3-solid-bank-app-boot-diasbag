package com.example.demo;

import com.example.demo.transaction.Transaction;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

    @Modifying
    @Query("INSERT INTO Transaction (account_id, amount) VALUES (:accountId, :amount)")
    void addTransaction(String accountId, double amount);
}
