package com.example.demo.services;

import com.example.demo.AccountRepository;
import com.example.demo.TransactionRepository;
import com.example.demo.account.Account;
//import com.example.demo.dao.AccountDAO;
import com.example.demo.account.AccountWithdraw;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AccountWithdrawServiceImpl implements AccountWithdrawService {
    //private AccountDAO accountDAO;
    private AccountRepository accountRepository;

//    public  AccountWithdrawServiceImpl(AccountDAO accountDAO) {
//        this.accountDAO = accountDAO;
//    }


    //Метод withdraw() выполняет снятие денег вызывая и передавая параметры в updateAccount()
    @Override
    public void withdraw(double amount, Account account) {
        accountRepository.updateAccount(account.getId(), -amount);
        //accountDAO.updateAccount(account, -amount);
    }
}
