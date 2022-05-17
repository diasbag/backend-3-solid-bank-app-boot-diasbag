package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountListingServiceImpI implements AccountListingService{
    private AccountDAO accountDAO;

    public AccountListingServiceImpI(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    //Возвращает Акк клиента
    @Override
    public Account getClientAccount(String clientID, String accountID) {

        return accountDAO.getClientAccount(clientID, accountID);
    }

    //Возвращает акк клиента для вывода денег
    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {

        return accountDAO.getClientWithdrawAccount(clientID, accountID);
    }

    //Возвращает счета клиентов
    @Override
    public List<Account> getClientAccounts(String clientID) {
        return accountDAO.getClientAccounts(clientID);
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        return null;
    }
}
