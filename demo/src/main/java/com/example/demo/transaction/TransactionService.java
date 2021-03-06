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

    public ResponseEntity<?> getTransactions(String accountID, String clientId) {
        Account account = accountRepository.findAccountByIdAndClientID(accountID, clientId);
        if (account == null) {
            return new ResponseEntity<>("Transactions not found!!!", HttpStatus.NOT_FOUND);
        }
       List<Transaction> list = transactionRepository.findAllByAccountId(account.getId());
        return new ResponseEntity<>(list , HttpStatus.OK);
    }

    public ResponseEntity<String> deposit(String accountId, TransactionRequest transactionRequest, String clientId) {
        Account account = accountRepository.findAccountByIdAndClientID(accountId, clientId);
        if (account == null) {
            return new ResponseEntity<>("Account not Found", HttpStatus.NOT_FOUND);
        }
        accountRepository.updateAccount(account.getId(), transactionRequest.getAmount());
        Transaction transaction = Transaction.builder().
                amount(transactionRequest.getAmount()).
                accountId(accountId).
                build();
        transactionRepository.save(transaction);
        return new ResponseEntity<>("deposit: " + transactionRequest.getAmount() + " to " + accountId, HttpStatus.OK );
    }

    public ResponseEntity<String> withdraw(String accountId, TransactionRequest transactionRequest, String clientId) {
        Account account = accountRepository.findAccountByIdAndClientID(accountId, clientId);
        if (account == null) {
            return new ResponseEntity<>("Account not Found", HttpStatus.NOT_FOUND);
        }
        if (account.isWithdrawAllowed() == false) {
            return new ResponseEntity<>("Can't Withdraw money from FIXED account!!!", HttpStatus.NOT_FOUND);
        }
        double balance = account.getBalance();
        if (transactionRequest.getAmount() < 0 ) {
            return new ResponseEntity<>("Amount cannot be less than 0!!!", HttpStatus.BAD_REQUEST);
        }
        if(transactionRequest.getAmount() > balance) {
            return new ResponseEntity<>("There is not enough money in the account!!!", HttpStatus.BAD_REQUEST);
        }
        transactionWithdraw.execute(account , transactionRequest.getAmount());
        return new ResponseEntity<>("withdraw:" + transactionRequest.getAmount() + " from " + accountId, HttpStatus.OK);
    }

    public ResponseEntity<String> transfer(String accountId, String clientId, TransferRequest transferRequest) {
        Account account = accountRepository.findAccountByIdAndClientID(accountId, clientId);
        Account acc = accountRepository.findById(transferRequest.getAccountId()).orElse(null);
        double balance = account.getBalance();
        if (account == null) {
            return new ResponseEntity<>("Account not found!!!", HttpStatus.NOT_FOUND);
        }
        if (acc == null) {
            return new ResponseEntity<>("Destination account not found!!!", HttpStatus.NOT_FOUND);
        }
        if (transferRequest.getAmount() < 0) {
            return new ResponseEntity<>("Amount cannot be less than 0!!!", HttpStatus.BAD_REQUEST);
        }
        if (transferRequest.getAmount() > balance) {
            return new ResponseEntity<>("There is not enough money in the account!!!", HttpStatus.BAD_REQUEST);
        }
        if (account.isWithdrawAllowed() && acc != null) {
            transactionWithdraw.execute(account, transferRequest.getAmount());
            accountRepository.updateAccount(acc.getId(), transferRequest.getAmount());
            Transaction transaction1 = Transaction.builder().
                    amount(transferRequest.getAmount()).
                    accountId(transferRequest.getAccountId()).
                    build();
            transactionRepository.save(transaction1);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }
        return new ResponseEntity<>("ERROR", HttpStatus.BAD_REQUEST);
    }
}
