package com.example.demo;

import com.example.demo.account.Account;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountService {

    private AccountRepository accountRepository;

    private  BankCore bankCore;

    public List<Account> getAccounts() {
        return accountRepository.getAccounts();
    }
    public ResponseEntity<?> getAccountById(String id) {
        Account account = accountRepository.findByIdEquals(id);
        if (account == null) {
            return new ResponseEntity<>("Account not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    public ResponseEntity<String> deleteById(String accountId) {
        Account account = accountRepository.findById(accountId).orElse(null);
        if (account == null) {
            return new ResponseEntity<>("Account does not exist!!!", HttpStatus.NOT_FOUND);
        }
        accountRepository.deleteById(accountId);
        return new ResponseEntity<>("Account " + accountId + " deleted", HttpStatus.OK );
    }
}
