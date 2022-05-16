package com.example.demo;

import com.example.demo.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountBasicCLI {
    private CreateAccountOperationUI createAccountOperationUI;
    private BankCore bankCore;
    private AccountListingService accountListing;

    public AccountBasicCLI(CreateAccountOperationUI createAccountOperationUI, BankCore bankCore, AccountListingService accountListing) {
        this.createAccountOperationUI = createAccountOperationUI;
        this.bankCore = bankCore;
        this.accountListing = accountListing;
    }

    public void createAccountRequest(String clientID) {
        try {
            AccountType accType = createAccountOperationUI.requestAccountType();
            bankCore.createNewAccount(accType, clientID);
        } catch (Exception e) {
            System.out.println("Incorrect input");
           // System.out.println(e);
        }

    }

    public void getAccounts(String clientID) {
        List<Account> accountList = accountListing.getClientAccounts(clientID);
        System.out.println(accountList);
    }
}
