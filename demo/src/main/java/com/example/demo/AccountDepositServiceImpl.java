package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class AccountDepositServiceImpl implements AccountDepositService{
    private AccountDAO accountDAO;

    AccountDepositServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }
    @Override
    public void deposit(double amount, Account account) {
        if (amount < 0) {
            System.out.println("Incorrect value");
            return;
        }
        accountDAO.updateAccount(account, amount);

    }
}
