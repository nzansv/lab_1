package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Bank {
    private List<Account> accounts = new ArrayList<>();
    private int bankNO;
    private String city;

    Scanner in = new Scanner(System.in);

    public Bank() {
    }

    @Autowired
    public Bank(List<Account> accounts, @Value("${bank.bankNO}")int bankNO, @Value("${bank.city}")String city) {
        this.accounts = accounts;
        this.bankNO = bankNO;
        this.city = city;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public int getBankNO() {
        return bankNO;
    }

    public void setBankNO(int bankNO) {
        this.bankNO = bankNO;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void getBankAccountsList() {
        for (Account account : accounts) {
            System.out.println(account.getLogin());
        }
    }

    public boolean auth() {
        boolean isCorrect = true;

        while (isCorrect) {
            System.out.println("Login: [bob/kate]");
            String login = in.nextLine();
            System.out.println("Password: [12345]");
            String password = in.nextLine();

            for (Account account : this.getAccounts()) {
                if (login.equals(account.getLogin()) && password.equals(account.getPassword())) {
                    System.out.println("Hello, " + account.getLogin() + "!");
                    isCorrect = false;

                } else
                    System.out.println("Incorrect login or password! Try again...");
                break;
            }
        }
        return true;
    }
}
