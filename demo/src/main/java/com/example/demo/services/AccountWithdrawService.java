package com.example.demo.services;

import com.example.demo.account.Account;
import com.example.demo.account.AccountWithdraw;
import org.springframework.stereotype.Service;

@Service
public interface AccountWithdrawService {
    void withdraw(double amount, Account account);
}
