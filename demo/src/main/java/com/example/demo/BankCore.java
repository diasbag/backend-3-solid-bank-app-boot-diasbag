package com.example.demo;

import com.example.demo.account.AccountType;
import com.example.demo.services.AccountCreationService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BankCore {
    private static long id = 1;
    private long lastAccountNumber = 1;
    @NonNull
    AccountCreationService accountCreation;
//    BankCore(AccountCreationService accountCreation) {
//        this.accountCreation = accountCreation;
//    }
    public void createNewAccount(AccountType accountType, String clientID) {
        accountCreation.create(accountType, id, clientID, lastAccountNumber);
        incrementLastAccountNumber();
    }
    public void incrementLastAccountNumber() {
        lastAccountNumber++;
    }
}
