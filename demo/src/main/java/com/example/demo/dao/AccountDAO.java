package com.example.demo.dao;

import com.example.demo.account.AccountWithdraw;
import com.example.demo.account.Account;
import com.example.demo.account.AccountType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDAO {
    List<Account> getClientAccounts(String clientID);
    void createNewAccount(Account account);
    void updateAccount(Account account, double amount);
    List<Account> getClientAccountsByType(String clientID, AccountType accountType);
    AccountWithdraw getClientWithdrawAccount(String clientID, String accountID);
    Account getClientAccount(String clientID, String accountID);
}
