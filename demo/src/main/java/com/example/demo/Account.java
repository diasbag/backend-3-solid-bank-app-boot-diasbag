package com.example.demo;

public class Account {
    AccountType accountType;
    private String id;
    private String clientID;
    private double balance;
    private boolean withdrawAllowed;
    public Account(AccountType accountType, String id, String clientID, double balance, boolean withdrawAllowed) {
        this.accountType = accountType;
        this.id = id;
        this.clientID = clientID;
        this.balance = balance;
        this.withdrawAllowed = withdrawAllowed;
    }
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
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
