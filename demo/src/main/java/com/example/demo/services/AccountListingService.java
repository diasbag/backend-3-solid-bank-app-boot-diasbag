package com.example.demo.services;

import com.example.demo.account.Account;
import com.example.demo.account.AccountType;
import com.example.demo.account.AccountWithdraw;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountListingService {
    Account getClientAccount(String clientID, String accountID);
    AccountWithdraw getClientWithdrawAccount(String clientID, String accountID);
    List<Account> getClientAccounts(String clientID);
    List<Account> getClientAccountsByType(String clientID, AccountType accountType);
}
