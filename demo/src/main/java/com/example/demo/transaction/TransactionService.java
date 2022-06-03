package com.example.demo.transaction;

import com.example.demo.AccountRepository;
import com.example.demo.TransactionRepository;
import com.example.demo.TransactionRequest;
import com.example.demo.account.Account;
import com.example.demo.services.AccountListingService;
import com.example.demo.services.AccountWithdrawService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class TransactionService {
    private TransactionRepository transactionRepository;
    private AccountRepository accountRepository;
    private TransactionWithdraw transactionWithdraw;
    private AccountListingService accountListingService;

    public List<Transaction> getTransactions(String accountID) {
        return transactionRepository.findAllByAccountId(accountID);
    }

    public ResponseEntity<String> deposit(String accountId, TransactionRequest transactionRequest) {
        Account account = accountRepository.findAccountByIdAndClientID(accountId, "1");
        if (account == null) {
            return new ResponseEntity<>("Account not Found", HttpStatus.NOT_FOUND);
        }
        accountRepository.updateAccount(account.getId(), transactionRequest.getAmount());
        Transaction transaction = Transaction.builder().
                amount(transactionRequest.getAmount()).
                accountId(accountId).
                build();
        transactionRepository.save(transaction);
        return new ResponseEntity<>("deposit:" + transactionRequest.getAmount(), HttpStatus.OK );
    }

    public ResponseEntity<String> withdraw(String accountId, TransactionRequest transactionRequest) {
        Account accountWithdraw = accountListingService.getClientWithdrawAccount("1",accountId);
        if (accountWithdraw == null) {
            return new ResponseEntity<>("Account Not Found!!", HttpStatus.NOT_FOUND);
        }
        double balance = accountWithdraw.getBalance();
        if (transactionRequest.getAmount() < 0 ) {
            return new ResponseEntity<>("Amount cannot be less than 0!!!", HttpStatus.BAD_REQUEST);
        }
        if(transactionRequest.getAmount() > balance) {
            return new ResponseEntity<>("There is not enough money in the account!!!", HttpStatus.BAD_REQUEST);
        }
        transactionWithdraw.execute(accountWithdraw, transactionRequest.getAmount());
        return new ResponseEntity<>("withdraw:" + transactionRequest.getAmount(), HttpStatus.OK);
    }
}
