package com.example.demo.services;

import com.example.demo.AccountRepository;
import com.example.demo.TransactionRepository;
//import com.example.demo.dao.AccountDAO;
import com.example.demo.account.Account;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AccountDepositServiceImpl implements AccountDepositService {
   // private AccountDAO accountDAO;
    private AccountRepository accountRepository;

//    AccountDepositServiceImpl(AccountDAO accountDAO) {
//        this.accountDAO = accountDAO;
//    }
    @Override
    public void deposit(double amount, Account account) {
        if (amount < 0) {
            System.out.println("Incorrect value");
            return;
        }
        accountRepository.updateAccount(account.getId(), amount);

    }
}
