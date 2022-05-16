package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Getter
@Component
public class MyCLI implements CLIUI{
    private Scanner scanner;

    MyCLI() {
        this.scanner = new Scanner(System.in);
    }

    MyCLI(Scanner scanner) {
        this.scanner = scanner;
    }

    public double requestClientAmount() {
        double amount;
        String str = scanner.nextLine();
        try {
            amount = Double.parseDouble(str);
            return amount;
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public String requestClientAccountNumber() {
        System.out.println("Type account ID");
        String accountNumber = scanner.nextLine();
        return accountNumber;
    }
    @Override
    public AccountType requestAccountType() {
        String accType = scanner.nextLine();
        return AccountType.valueOf(accType);
    }
}
