package com.example.demo.services;

import com.example.demo.account.Account;
import org.springframework.stereotype.Service;

@Service
public interface AccountDepositService {
    void deposit(double amount, Account account);
}
