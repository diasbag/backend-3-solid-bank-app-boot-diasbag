package com.example.demo.transaction;

import com.example.demo.TransactionRepository;
import com.example.demo.dao.TransactionDAO;
import com.example.demo.account.Account;
import com.example.demo.services.AccountDepositService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionDeposit {
    private AccountDepositService accountDepositService;
    private TransactionDAO transactionDAO;
    private TransactionRepository transactionRepository;
//    public TransactionDeposit(AccountDepositService accountDepositService, TransactionDAO transactionDAO) {
//        this.accountDepositService = accountDepositService;
//        this.transactionDAO = transactionDAO;
//    }

    public void execute(Account account, double amount) {
        accountDepositService.deposit(amount, account);
        Transaction transaction = new Transaction(amount, account.getId());
        transactionRepository.save(transaction);
        //transactionRepository.addTransaction(account.getId(), amount);
    }
}
