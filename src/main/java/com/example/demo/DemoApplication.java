package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigration.class);

        Account account = context.getBean("account", Account.class);
        Card card = context.getBean("card", Card.class);

        System.out.println("Login: " + account.getLogin());
        System.out.println("Password:" + account.getPassword());
        System.out.println("Card NO: " + card.getCardNo());
        System.out.println("Card balance: " + card.getBalance());
        System.out.println("Card CVV: " + card.getCvv());
        System.out.println("Card PIN: " + card.getPin());


//        ATM atm = context.getBean("atm", ATM.class);
//        Bank bank = context.getBean("bank", Bank.class);
//        BankServiceContext bankServiceContext = context.getBean("bankServiceContext", BankServiceContext.class);
//
//
//        boolean isCorrect = true;
//
//        while (isCorrect) {
//            System.out.println("Login: [bob]");
//            String login = in.nextLine();
//            System.out.println("Password: [123]");
//            String password = in.nextLine();
//            for (Account a : bank.getAccounts()) {
//                if (login.equals(account.getLogin()) && password.equals(account.getPassword())) {
//                    System.out.println("Hello, " + account.getLogin() + "!");
//                    isCorrect = false;
//                    int choice = -1;
//                    while(choice!=0) {
//                        System.out.println("1. Balance");
//                        System.out.println("2. Withdraw");
//                        System.out.println("3. Top Up");
//                        System.out.println("4. Change PIN");
//                        System.out.println("0. Exit");
//
//                        choice = in.nextInt();
//                        in.nextLine();
//
//                        switch (choice){
//                            case 1:
//                                atm.balance(account.getCard());
//                                break;
//                            case 2:
//                                bankServiceContext.setBankService(new WithdrawStrategy());
//                                bankServiceContext.bankingProcess(account.getCard());
//                                break;
//                            case 3:
//                                bankServiceContext.setBankService(new TopUpStrategy());
//                                bankServiceContext.bankingProcess(account.getCard());
//                                break;
//                            case 4:
//                                account.getCard().changePIN();
//                                break;
//                        }
//                    }
//                } else
//                    System.out.println("Incorrect login or password! Try again...");
//                break;
//            }
//        }

    }
}
