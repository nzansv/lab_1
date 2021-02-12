package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
        Scanner in = new Scanner(System.in);

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        ATM atm = context.getBean("atm", ATM.class);

        BankServiceContext bankServiceContext = new BankServiceContext();

        Account accountF = context.getBean("account", Account.class);
        accountF.setLogin("bob");
        accountF.setPassword("123");
        accountF.setPhoneNumber("87079537823");

        Card cardF = context.getBean("card", Card.class);
        cardF.setCardNo("6789");
        cardF.setBalance(24000);
        cardF.setCvv(232);
        cardF.setExpDate("11/22");
        cardF.setPin(123);
        accountF.setCard(cardF);

        Account accountS = context.getBean("account", Account.class);
        accountS.setLogin("kate");
        accountS.setPassword("123");
        accountS.setPhoneNumber("87079537823");

        Card cardS = context.getBean("card", Card.class);
        cardS.setCardNo("12345");
        cardS.setBalance(34000);
        cardS.setCvv(232);
        cardS.setExpDate("22/23");
        cardS.setPin(123);
        accountS.setCard(cardS);

        Bank bank = context.getBean("bank", Bank.class);
        bank.addAccount(accountF);
        bank.addAccount(accountS);

        boolean isCorrect = true;

        while (isCorrect) {
            System.out.println("Login: [bob/kate]");
            String login = in.nextLine();
            System.out.println("Password: [123]");
            String password = in.nextLine();
            for (Account account : bank.getAccounts()) {
                if (login.equals(account.getLogin()) && password.equals(account.getPassword())) {
                    System.out.println("Hello, " + account.getLogin() + "!");
                    isCorrect = false;
                    int choice = -1;
                    while(choice!=0) {
                        System.out.println("1. Balance");
                        System.out.println("2. Withdraw");
                        System.out.println("3. Top Up");
                        System.out.println("4. Change PIN");
                        System.out.println("0. Exit");

                        choice = in.nextInt();
                        in.nextLine();

                        switch (choice){
                            case 1:
                                atm.balance(account.getCard());
                                break;
                            case 2:
                                bankServiceContext.setBankService(new WithdrawStrategy());
                                bankServiceContext.bankingProcess(account.getCard());
                                break;
                            case 3:
                                bankServiceContext.setBankService(new TopUpStrategy());
                                bankServiceContext.bankingProcess(account.getCard());
                                break;
                            case 4:
                                account.getCard().changePIN();
                                break;
                        }
                    }
                } else
                    System.out.println("Incorrect login or password! Try again...");
                break;
            }
        }

        ((ClassPathXmlApplicationContext) context).close();
    }
}
