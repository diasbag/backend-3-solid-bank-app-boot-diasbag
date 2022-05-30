package com.example.demo.account;

public class SavingAccount extends AccountWithdraw {
    public SavingAccount(String accountType, String id, String clientID, double balance, boolean withdrawAllowed) {
        super(accountType, id, clientID, balance, withdrawAllowed);
    }
}
