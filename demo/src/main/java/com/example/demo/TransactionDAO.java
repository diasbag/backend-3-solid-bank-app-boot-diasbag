package com.example.demo;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionDAO {
    List<Transaction> getTransactions();
    void addTransaction(Transaction transaction);
}
