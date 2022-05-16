package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class BankCore {
    private static long id = 1;
    private long lastAccountNumber = 1;
    AccountCreationService accountCreation;
    BankCore(AccountCreationService accountCreation) {
        this.accountCreation = accountCreation;
    }
    public void createNewAccount(AccountType accountType, String clientID) {
        accountCreation.create(accountType, id, clientID, lastAccountNumber);
        incrementLastAccountNumber();
    }
    public void incrementLastAccountNumber() {
        lastAccountNumber++;
    }
}
