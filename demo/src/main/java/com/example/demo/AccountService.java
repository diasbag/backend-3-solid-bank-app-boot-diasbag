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

    public List<Account> getAccounts(String clientId) {

        return accountRepository.getAccountsByClientID(clientId);
    }
    public ResponseEntity<?> getAccountById(String id, String clienId) {
        Account account = accountRepository.findAccountByIdAndClientID(id, clienId);
        if (account == null) {
            return new ResponseEntity<>("Account not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    public ResponseEntity<String> deleteById(String accountId, String clientId) {
        Account account = accountRepository.findAccountByIdAndClientID(accountId, clientId);
        if (account == null) {
            return new ResponseEntity<>("Account does not exist!!!", HttpStatus.NOT_FOUND);
        }
        accountRepository.deleteById(accountId);
        return new ResponseEntity<>("Account " + accountId + " deleted", HttpStatus.OK );
    }
}
