package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Account {
    AccountType accountType;
    private String id;
    private String clientID;
    private double balance;
    private boolean withdrawAllowed;
    public String toString() {
        return "[Account{, id='" + id + "', clientID='" + clientID + "', balance=" + balance;
    }
    public String getClientID() {
        return clientID;
    }
    public void setClientID(String clientID) {
        this.clientID = clientID;
    }
    public boolean isWithdrawAllowed() {
        return withdrawAllowed;
    }
    public void setWithdrawAllowed(boolean withdrawAllowed){
        this.withdrawAllowed = withdrawAllowed;
    }
    public AccountType getAccountType() {
        return this.accountType;
    }
    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
