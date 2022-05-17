package com.example.demo.cli;

import com.example.demo.services.AccountListingService;
import com.example.demo.transaction.TransactionDeposit;
import com.example.demo.account.Account;
import org.springframework.stereotype.Component;

@Component
public class TransactionDepositCLI {
    private TransactionDeposit transactionDeposit;
    private WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    private AccountListingService accountListing;

    public TransactionDepositCLI(TransactionDeposit transactionDeposit, WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI, AccountListingService accountListing){
        this.transactionDeposit = transactionDeposit;
        this.withdrawDepositOperationCLIUI = withdrawDepositOperationCLIUI;
        this.accountListing = accountListing;
    }

    public  void depositMoney(String clientID) {
        String accountNumber = withdrawDepositOperationCLIUI.requestClientAccountNumber();
        Account account = accountListing.getClientAccount(clientID, accountNumber);
       // System.out.println(account);
        if (account == null) {
            System.out.println("Account not Found");
            return;
        }
        System.out.println("Type amount of money");
        double amount = withdrawDepositOperationCLIUI.requestClientAmount();
        if (amount <= 0) {
            System.out.println("Incorrect input");
            return;
        }
        try {
            transactionDeposit.execute(account, amount);
            System.out.printf("%.2f$ transferred to %s account\n", amount, accountNumber);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
