package com.example.demo.services;

import com.example.demo.dao.AccountDAO;
import com.example.demo.account.AccountWithdraw;
import org.springframework.stereotype.Component;

@Component
public class AccountWithdrawServiceImpl implements AccountWithdrawService {
    private AccountDAO accountDAO;
    public  AccountWithdrawServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }


    //Метод withdraw() выполняет снятие денег вызывая и передавая параметры в updateAccount()
    @Override
    public void withdraw(double amount, AccountWithdraw account) {
        accountDAO.updateAccount(account, -amount);
    }
}
