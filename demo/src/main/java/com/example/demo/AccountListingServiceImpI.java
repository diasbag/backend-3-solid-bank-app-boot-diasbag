package com.example.demo;

import java.util.List;

public class AccountListingServiceImpI implements AccountListingService{
    private AccountDAO accountDAO;

    public AccountListingServiceImpI(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }
    @Override
    public Account getClientAccount(String clientID, String accountID) {
        return null;
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {
        return null;
    }

    @Override
    public List<Account> getClientAccounts(String clientID) {
        return accountDAO.getClientAccounts(clientID);
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        return null;
    }
}
