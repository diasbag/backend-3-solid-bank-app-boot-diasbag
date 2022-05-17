package com.example.demo.dao;

import com.example.demo.account.Account;
import com.example.demo.account.AccountType;
import com.example.demo.account.AccountWithdraw;
import com.example.demo.dao.AccountDAO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryAccountDAO implements AccountDAO {
    private List<Account> accountList;
    MemoryAccountDAO() {
        this.accountList = new ArrayList<Account>();
    }


    //Возвращает список Счетов
    @Override
    public List<Account> getClientAccounts(String clientID) {
        return accountList;
    }

    // Создает новый акк
    @Override
    public void createNewAccount(Account account) {

        accountList.add(account);
        System.out.println("Bank account created");
    }

    //Обновляет акк
    @Override
    public void updateAccount(Account account, double amount) {

        account.setBalance(account.getBalance() + amount);
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        return null;
    }

    //Возвращает счета AccountWithdraw
    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {
        for(Account account: accountList) {
            if (account.getClientID().equals(clientID) && account.getId().equals(accountID) && account.isWithdrawAllowed()) {
                return (AccountWithdraw) account;
            }
        }
        return null;
    }

    //Возвращает акк клиента по ID
    @Override
    public Account getClientAccount(String clientID, String accountID) {
        for (Account account : accountList) {
            if (account.getClientID().equals(clientID) && account.getId().equals(accountID)) {
                return account;
            }
        }
        return null;
    }
}
