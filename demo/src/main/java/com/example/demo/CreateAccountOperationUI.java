package com.example.demo;

import com.example.demo.account.AccountType;
import org.springframework.stereotype.Service;

@Service
public interface CreateAccountOperationUI {
    AccountType requestAccountType();
}
