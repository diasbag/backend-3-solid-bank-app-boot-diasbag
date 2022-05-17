package com.example.demo.dao;

import com.example.demo.transaction.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class MemoryTransactionDAO implements TransactionDAO {
    private List<Transaction> transactions;

    @Override
    public List<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}
