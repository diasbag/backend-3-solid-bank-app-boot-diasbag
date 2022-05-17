package com.example.demo.cli;

import org.springframework.stereotype.Service;

@Service
public interface WithdrawDepositOperationCLIUI {
    double requestClientAmount();
    String requestClientAccountNumber();
}
