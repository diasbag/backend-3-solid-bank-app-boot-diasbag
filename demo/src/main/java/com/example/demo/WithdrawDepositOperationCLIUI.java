package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public interface WithdrawDepositOperationCLIUI {
    double requestClientAmount();
    String requestClientAccountNumber();
}
