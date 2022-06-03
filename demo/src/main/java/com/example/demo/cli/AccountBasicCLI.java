package com.example.demo.cli;

import com.example.demo.AccountRepository;
import com.example.demo.services.AccountListingService;
import com.example.demo.BankCore;
import com.example.demo.CreateAccountOperationUI;
import com.example.demo.account.Account;
import com.example.demo.account.AccountType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class AccountBasicCLI {
    CreateAccountOperationUI createAccountOperationUI;
    BankCore bankCore;
    AccountListingService accountListing;
    AccountRepository accountRepository;

//    public AccountBasicCLI(CreateAccountOperationUI createAccountOperationUI, BankCore bankCore, AccountListingService accountListing) {
//        this.createAccountOperationUI = createAccountOperationUI;
//        this.bankCore = bankCore;
//        this.accountListing = accountListing;
//    }

    public void createAccountRequest(String clientID) {
        try {
            String accType = String.valueOf(createAccountOperationUI.requestAccountType());
            bankCore.createNewAccount(accType, clientID);
        } catch (Exception e) {
            System.out.println("Incorrect Account Type");
            System.out.println(e);
        }

    }

    public void getAccounts(String clientID) {
        List<Account> accountList = accountListing.getClientAccounts(clientID);
        System.out.println(accountList);
    }
}
