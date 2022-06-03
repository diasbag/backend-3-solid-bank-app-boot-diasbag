package com.example.demo.cli;

import com.example.demo.account.Account;
import com.example.demo.services.AccountListingService;
import com.example.demo.transaction.TransactionWithdraw;
import com.example.demo.account.AccountWithdraw;
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

    //Метод withdrawMoney выполняет снятие денег вызывая функцию execute()
    public void withdrawMoney(String clientID) {
        String accountNumber = withdrawDepositOperationCLIUI.requestClientAccountNumber();
        Account accountWithdraw = accountListing.getClientWithdrawAccount(clientID, accountNumber);
        if (accountWithdraw == null) {
            System.out.println("You cannot withdraw money!!");
            return;
        }
        System.out.println("Type amount of money for withdraw");
        double amount  = withdrawDepositOperationCLIUI.requestClientAmount();
        if (amount <= 0) {
            System.out.println("Incorrect input");
            return;
        }
        if(accountWithdraw.getBalance() < amount) {
            System.out.println("There is not enough money in the account!!!");
            return;
        }
            transactionWithdraw.execute(accountWithdraw, amount);
            System.out.printf("%.2f$ transferred from %s account\n", amount, accountNumber);

    }
}
