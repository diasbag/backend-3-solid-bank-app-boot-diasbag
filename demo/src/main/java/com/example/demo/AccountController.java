package com.example.demo;

import com.example.demo.account.Account;
import com.example.demo.cli.AccountBasicCLI;
import com.example.demo.transaction.Transaction;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
@SecurityRequirement(name = "basicauth")
@AllArgsConstructor
public class AccountController {
    private AccountService accountService;
    private TransactionRepository transactionRepository;
    private  AccountRepository accountRepository;
    private UserRepository userRepository;
    private BankCore bankCore;


    @GetMapping()

    public List<Account> getAccounts() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = userDetails.getUsername();
        User user = userRepository.findByLogin(name);
        String id = String.valueOf(user.getId());
        return accountService.getAccounts(id);
    }

    @GetMapping("/{account_id}")
    public ResponseEntity<?> getAccountById(@PathVariable("account_id") long id) {
        String accNumber = String.format("%03d%06d", 1, id);
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = userDetails.getUsername();
        User user = userRepository.findByLogin(name);
        String cleintId = String.valueOf(user.getId());
        return accountService.getAccountById(accNumber, cleintId);
    }
    @DeleteMapping("/{account_id}")
    public ResponseEntity<String> deleteAccount(@PathVariable long account_id) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = userDetails.getUsername();
        User user = userRepository.findByLogin(name);
        String id = String.valueOf(user.getId());
        String accNumber = String.format("%03d%06d", 1, account_id);
        return accountService.deleteById(accNumber, id);
    }
    @PostMapping
    public ResponseEntity<String> createAccount(@RequestBody AccountRequest accountRequest) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = userDetails.getUsername();
        User user = userRepository.findByLogin(name);
        String id = String.valueOf(user.getId());
        System.out.println(id);
        if (accountRequest.getAccountType().equals("FIXED") ||
                accountRequest.getAccountType().equals("SAVING") ||
                accountRequest.getAccountType().equals("CHECKING")) {
            bankCore.createNewAccount(accountRequest.getAccountType(), id);
            return new ResponseEntity<>("Account created", HttpStatus.OK);
        }
        return new ResponseEntity<>("This type of account does not exist", HttpStatus.BAD_REQUEST);
    }

}
