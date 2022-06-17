package com.example.demo.transaction;

import lombok.Data;

@Data
public class TransferRequest {
    private String accountId;
    private double amount;
}
