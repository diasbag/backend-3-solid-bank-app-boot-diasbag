package com.example.demo;

import com.example.demo.transaction.Transaction;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

//    @Modifying
//    @Query("INSERT INTO Transaction (account_id, amount) VALUES (:accountId, :amount)")
//    void addTransaction(String accountId, double amount);
//

    @Query("SELECT * FROM Transaction t Where t.account_id = :accountId")
    List<Transaction> findAllByAccountId(String accountId);

    List<Transaction> getTransactionsByAccountId(String accountId);
}
