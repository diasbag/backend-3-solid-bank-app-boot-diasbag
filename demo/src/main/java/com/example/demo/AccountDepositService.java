package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface AccountDepositService {
    void deposit(double amount, Account account);
}
