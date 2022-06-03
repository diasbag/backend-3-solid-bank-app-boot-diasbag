package com.example.demo.transaction;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.*;
import org.springframework.data.annotation.Id;

@Data
//@Builder
//@AllArgsConstructor

public class Transaction {

    private @Id int transaction_id;
    private double amount;
    private String accountId;

    @Builder
    public Transaction(double amount, String accountId) {
        this.amount = amount;
        this.accountId = accountId;
    }

    public int getId() {
        return transaction_id;
    }

    public void setId(int id) {
        this.transaction_id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
