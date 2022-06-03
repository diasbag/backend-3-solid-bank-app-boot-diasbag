package com.example.demo;

import com.example.demo.account.Account;
import com.example.demo.cli.AccountBasicCLI;
import com.example.demo.transaction.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
@AllArgsConstructor
public class AccountController {
    private AccountService accountService;
    private TransactionRepository transactionRepository;
    private  AccountRepository accountRepository;
    private BankCore bankCore;


    @GetMapping()
    public List<Account> getAccounts() {
        return accountService.getAccounts();
    }

    @GetMapping("/{account_id}")
    public ResponseEntity<?> getAccountById(@PathVariable("account_id") long id) {
        String accNumber = String.format("%03d%06d", 1, id);
        return accountService.getAccountById(accNumber);
    }
    @DeleteMapping("/{account_id}")
    public ResponseEntity<String> deleteAccount(@PathVariable long account_id) {
        String accNumber = String.format("%03d%06d", 1, account_id);
        return accountService.deleteById(accNumber);
    }
    @PostMapping
    public ResponseEntity<String> createAccount(@RequestBody AccountRequest accountRequest) {
        if (accountRequest.getAccountType().equals("FIXED") ||
                accountRequest.getAccountType().equals("SAVING") ||
                accountRequest.getAccountType().equals("CHECKING")) {
            bankCore.createNewAccount(accountRequest.getAccountType(), "1");
            return new ResponseEntity<>("Account created", HttpStatus.OK);
        }
        return new ResponseEntity<>("This type of account does not exist", HttpStatus.BAD_REQUEST);
    }

}
