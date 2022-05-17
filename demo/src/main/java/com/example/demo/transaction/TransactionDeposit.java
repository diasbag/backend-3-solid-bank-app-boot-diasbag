package com.example.demo.transaction;

import com.example.demo.dao.TransactionDAO;
import com.example.demo.account.Account;
import com.example.demo.services.AccountDepositService;
import org.springframework.stereotype.Component;

@Component
public class TransactionDeposit {
    private AccountDepositService accountDepositService;
    private TransactionDAO transactionDAO;
    public TransactionDeposit(AccountDepositService accountDepositService, TransactionDAO transactionDAO) {
        this.accountDepositService = accountDepositService;
        this.transactionDAO = transactionDAO;
    }

    public void execute(Account account, double amount) {
        accountDepositService.deposit(amount, account);
    }
}
