package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class AccountWithdrawServiceImpl implements AccountWithdrawService{
    private AccountDAO accountDAO;
    public  AccountWithdrawServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void withdraw(double amount, AccountWithdraw account) {
        if (amount < 0) {
            System.out.println("Incorrect value");
            return;
        }
        if (account.getBalance() < amount) {
            System.out.println("There is not enough money in the account!!!");
            return;
        }
        accountDAO.updateAccount(account, -amount);
    }
}
