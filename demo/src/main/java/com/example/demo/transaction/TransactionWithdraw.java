package com.example.demo.transaction;

import com.example.demo.TransactionRepository;
import com.example.demo.account.Account;
import com.example.demo.dao.TransactionDAO;
import com.example.demo.account.AccountWithdraw;
import com.example.demo.services.AccountWithdrawService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionWithdraw {
    private AccountWithdrawService accountWithdrawService;
    private TransactionRepository transactionRepository;

    //Метод execute() выполняет снятие денег вызывая метод withdraw() из AccountWithdrawService
    public void execute(Account accountWithdraw, double amount) {
        accountWithdrawService.withdraw(amount, accountWithdraw);
        Transaction transaction= new Transaction(-1*amount,accountWithdraw.getId());
        transactionRepository.save(transaction);
        //transactionRepository.addTransaction(accountWithdraw.getId(), -amount);
    }
}
