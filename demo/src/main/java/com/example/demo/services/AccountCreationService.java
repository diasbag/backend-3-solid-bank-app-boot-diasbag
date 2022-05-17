package com.example.demo.services;

import com.example.demo.account.AccountType;
import org.springframework.stereotype.Component;

@Component
public interface AccountCreationService {
    void create(AccountType accountType, long bankID, String clientID, long accountID);
}
