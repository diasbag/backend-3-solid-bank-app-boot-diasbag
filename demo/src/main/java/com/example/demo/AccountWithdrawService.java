package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public interface AccountWithdrawService {
    void withdraw(double amount, AccountWithdraw account);
}
