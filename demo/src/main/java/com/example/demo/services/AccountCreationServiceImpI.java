package com.example.demo.services;

import com.example.demo.AccountRepository;
//import com.example.demo.dao.AccountDAO;
import com.example.demo.account.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class AccountCreationServiceImpI implements AccountCreationService {
    //AccountDAO accountDAO;
    private AccountRepository accountRepository;


    //Создает аккаунт для клиентов
    @Override
    public void create(AccountType accountType, long bankID, String clientID, long accountID) {
        String accType = accountType == null ? "" : accountType.toString();
        Account ac;
        if (accType.equals("FIXED")) {
            ac = new FixedAccount(accountType.toString(), String.format("%03d%06d", 1, accountID), clientID, 0, false);
            accountRepository.addAccount(ac.getAccountType(), ac.getId(), ac.getClientID(), ac.isWithdrawAllowed());
            System.out.println("Bank Account Created");
            //accountDAO.createNewAccount(ac);
        } else if (accType.equals("SAVING")){
            ac = new SavingAccount(accountType.toString(), String.format("%03d%06d", 1, accountID), clientID, 0, true);
            accountRepository.addAccount(ac.getAccountType(), ac.getId(), ac.getClientID(), ac.isWithdrawAllowed());
            System.out.println("Bank Account Created");

        } else if (accType.equals("CHECKING")) {
            ac = new CheckingAccount(accountType.toString(), String.format("%03d%06d", 1, accountID), clientID, 0, true);
            accountRepository.addAccount(ac.getAccountType(), ac.getId(), ac.getClientID(), ac.isWithdrawAllowed());
            System.out.println("Bank Account Created");

        } else {
            System.out.println("This type of account does not exist");
        }

    }
}
