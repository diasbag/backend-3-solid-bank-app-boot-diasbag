package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public interface AccountCreationService {
    void create(AccountType accountType, long bankID, String clientID, long accountID);
}
