package com.example.demo;

import java.util.Scanner;

public class MyCLI implements CLIUI{
    private Scanner scanner;

    MyCLI() {
        this.scanner = new Scanner(System.in);
    }

    MyCLI(Scanner scanner) {
        this.scanner = scanner;
    }

    public double requestClientAmount() {
        return 0;
    }

    public String requestClientAccountNumber() {
        return null;
    }
    @Override
    public AccountType requestAccountType() {
        String accType = scanner.nextLine();
        return AccountType.valueOf(accType);
    }
}
