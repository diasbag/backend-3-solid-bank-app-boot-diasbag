package com.example.demo;
import com.example.demo.AccountDeposit;
import org.springframework.stereotype.Component;

@Component
public class FixedAccount extends AccountDeposit{
    public FixedAccount(AccountType accountType, String id, String clientID, double balance, boolean withdrawAllowed) {
        super(accountType, id, clientID, balance, withdrawAllowed);
    }
}
