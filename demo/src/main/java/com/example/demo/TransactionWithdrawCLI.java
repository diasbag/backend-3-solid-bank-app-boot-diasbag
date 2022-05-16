package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class TransactionWithdrawCLI {
    private TransactionWithdraw transactionWithdraw;
    private WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    private AccountListingService accountListing;

    public TransactionWithdrawCLI(TransactionWithdraw transactionWithdraw, WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI, AccountListingService accountListing){
        this.transactionWithdraw = transactionWithdraw;
        this.withdrawDepositOperationCLIUI = withdrawDepositOperationCLIUI;
        this.accountListing = accountListing;
    }

    public void withdrawMoney(String clientID) {
        String accountNumber = withdrawDepositOperationCLIUI.requestClientAccountNumber();
        AccountWithdraw accountWithdraw = accountListing.getClientWithdrawAccount(clientID, accountNumber);
        if (accountWithdraw == null) {
            System.out.println("Account not Found");
            return;
        }
        System.out.println("Type amount of money for withdraw");
        double amount  = withdrawDepositOperationCLIUI.requestClientAmount();
        if (amount <= 0) {
            System.out.println("Incorrect input");
            return;
        }
        transactionWithdraw.execute(accountWithdraw, amount);
    }
}
