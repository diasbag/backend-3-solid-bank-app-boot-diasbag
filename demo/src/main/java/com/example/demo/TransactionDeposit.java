package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class TransactionDeposit {
    private AccountDepositService accountDepositService;
    private TransactionDAO transactionDAO;
    public TransactionDeposit(AccountDepositService accountDepositService, TransactionDAO transactionDAO) {
        this.accountDepositService = accountDepositService;
        this.transactionDAO = transactionDAO;
    }

    public void execute(AccountWithdraw accountWithdraw, double amount) {
        accountDepositService.deposit(amount, accountWithdraw);
    }
}
