package com.example.demo;

import com.example.demo.account.Account;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account, String> {

    @Query("SELECT * FROM Account")
    List<Account> getAccounts();
    @Query("select id from Account a where  a.account_type =:accountType and a.client_id = :clientId")
    List<Account> getAccountsByAccountType(String clientId, String accountType);

    @Modifying
    @Query("insert into Account values(:id, :accountType, :clientID, 0.0,  :withdrawAllowed)")
    void addAccount(String accountType, String id, String clientID, Boolean withdrawAllowed);

    @Modifying
    @Query("UPDATE Account a SET a.balance = a.balance + :amount WHERE a.id = :accountId")
    void updateAccount(String accountId, double amount);

    Account findAccountByIdAndClientID(String accountId, String clientId);
    Account findByIdEquals(String id);

}
