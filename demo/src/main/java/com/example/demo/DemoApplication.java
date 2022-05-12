package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Scanner;


@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("props.xml");
        System.out.println("Welcome to CLI bank service Enter operation number:\n" +
                "1 - show accounts\n" +
                "2 - create account\n" +
                "3 - deposit\n" +
                "4 - withdraw\n" +
                "5 - transfer\n"  +
                "6 - this message\n" +
                "7 - exit\n");
        Scanner sc = new Scanner(System.in);
        AccountBasicCLI acc = context.getBean(AccountBasicCLI.class);

        while(true) {
            String operation = sc.nextLine();
            if (operation.equals("7")) {
                System.out.println("Application closed");
                System.exit(0);
            } else if (operation.equals("1")){
                acc.getAccounts("");
            } else if(operation.equals("2")) {
                System.out.println("Choose account type\n" + "[CHECKING, SAVING, FIXED]");
                acc.createAccountRequest("1");

            } else {
                System.out.println("Этого еще нет!!!");
            }
        }
    }

}
