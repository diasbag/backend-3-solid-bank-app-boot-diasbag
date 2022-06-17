package com.example.demo;

import com.example.demo.account.Account;
import com.example.demo.account.AccountDeposit;
import com.example.demo.services.AccountDepositService;
import com.example.demo.services.AccountListingService;
import com.example.demo.services.AccountWithdrawService;
import com.example.demo.transaction.Transaction;
import com.example.demo.transaction.TransactionService;
import com.example.demo.transaction.TransferRequest;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/accounts")
@SecurityRequirement(name = "basicauth")
public class TransactionController {

    private TransactionService transactionService;

    private AccountListingService accountListingService;
    private UserRepository userRepository;

    @GetMapping("/{account_id}/transactions")
    public ResponseEntity<?> getTransactions(@PathVariable("account_id") long accountId) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = userDetails.getUsername();
        User user = userRepository.findByLogin(name);
        String id = String.valueOf(user.getId());
        String accNumber = String.format("%03d%06d", 1, accountId);
        return transactionService.getTransactions(accNumber, id);
    }
    @PostMapping(value = "/{account_id}/deposit")
    public ResponseEntity<String> deposit(@PathVariable("account_id") long id, @RequestBody TransactionRequest transactionRequest) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = userDetails.getUsername();
        User user = userRepository.findByLogin(name);
        String clientId = String.valueOf(user.getId());
        String accNumber = String.format("%03d%06d", 1, id);
        return transactionService.deposit(accNumber, transactionRequest, clientId);
    }
    @PostMapping(value = "/{account_id}/withdraw")
    public ResponseEntity<String> withdraw(@PathVariable("account_id") long id, @RequestBody TransactionRequest transactionRequest) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = userDetails.getUsername();
        User user = userRepository.findByLogin(name);
        String clientId = String.valueOf(user.getId());
        String accNumber = String.format("%03d%06d", 1, id);
        return transactionService.withdraw(accNumber, transactionRequest, clientId);
    }
    @PostMapping(value = "/{account_id}/transfer")
    public ResponseEntity<String> transfer(@PathVariable("account_id") long accountId, @RequestBody TransferRequest transferRequest) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = userDetails.getUsername();
        User user = userRepository.findByLogin(name);
        String clientId = String.valueOf(user.getId());
        String accNumber = String.format("%03d%06d", 1, accountId);
        return transactionService.transfer(accNumber, clientId, transferRequest);
    }
}
