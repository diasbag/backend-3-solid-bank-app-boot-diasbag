package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class AccountCreationServiceImpI implements AccountCreationService{
    AccountDAO accountDAO;
    public AccountCreationServiceImpI(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    //Создает аккаунт для клиентов
    @Override
    public void create(AccountType accountType, long bankID, String clientID, long accountID) {
        String accType = accountType == null ? "" : accountType.toString();
        Account ac;
        if (accType.equals("FIXED")) {
            ac = new FixedAccount(accountType, String.format("%03d%06d", 1, accountID), clientID, 0, false);
            accountDAO.createNewAccount(ac);
        } else if (accType.equals("SAVING")){
            ac = new SavingAccount(accountType, String.format("%03d%06d", 1, accountID), clientID, 0, true);
            accountDAO.createNewAccount(ac);
        } else if (accType.equals("CHECKING")) {
            ac = new CheckingAccount(accountType, String.format("%03d%06d", 1, accountID), clientID, 0, true);
            accountDAO.createNewAccount(ac);
        } else {
            System.out.println("This type of account does not exist");
        }

    }
}
