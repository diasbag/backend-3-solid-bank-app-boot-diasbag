package com.example.demo;

import com.example.demo.account.Account;
import com.example.demo.account.AccountDeposit;
import com.example.demo.services.AccountDepositService;
import com.example.demo.services.AccountListingService;
import com.example.demo.services.AccountWithdrawService;
import com.example.demo.transaction.Transaction;
import com.example.demo.transaction.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TransactionController {

    private TransactionService transactionService;

    private AccountListingService accountListingService;

    @GetMapping("/accounts/{account_id}/transactions")
    public List<Transaction> getTransactions(@PathVariable("account_id") long accountId) {
        String accNumber = String.format("%03d%06d", 1, accountId);
        return transactionService.getTransactions(accNumber);
    }
    @PostMapping(value = "/{account_id}/deposit")
    public ResponseEntity<String> deposit(@PathVariable("account_id") long id, @RequestBody TransactionRequest transactionRequest) {
        String accNumber = String.format("%03d%06d", 1, id);
        return transactionService.deposit(accNumber, transactionRequest);
    }
    @PostMapping(value = "/{account_id}/withdraw")
    public ResponseEntity<String> withdraw(@PathVariable("account_id") long id, @RequestBody TransactionRequest transactionRequest) {
        String accNumber = String.format("%03d%06d", 1, id);
        return transactionService.withdraw(accNumber, transactionRequest);
    }
}
