package com.example.demo.services;

import com.example.demo.AccountRepository;
//import com.example.demo.dao.AccountDAO;
import com.example.demo.account.Account;
import com.example.demo.account.AccountType;
import com.example.demo.account.AccountWithdraw;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
@AllArgsConstructor
public class AccountListingServiceImpI implements AccountListingService {
   // private AccountDAO accountDAO;
    private AccountRepository accountRepository;
//    public AccountListingServiceImpI(AccountDAO accountDAO) {
//        this.accountDAO = accountDAO;
//    }

    //Возвращает Акк клиента
    @Override
    public Account getClientAccount(String clientID, String accountID) {

        return accountRepository.findById(accountID).orElse(null);
    }

    //Возвращает акк клиента для вывода денег
    @Override
    public Account getClientWithdrawAccount(String clientID, String accountID) {
        Account account = accountRepository.findAccountByIdAndClientID(accountID, clientID);
        if (account.isWithdrawAllowed()) {
            return account;
        }
        return null;
    }

    //Возвращает счета клиентов
    @Override
    public List<Account> getClientAccounts(String clientID) {
        List<Account> accountList = new ArrayList<>((Collection) accountRepository.findAll());
        return accountList;
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {

        return   accountRepository.getAccountsByAccountType(clientID, accountType.toString());
    }
}
