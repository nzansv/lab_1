package com.example.demo;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

@Component
public class ATM implements BankService {

    private final String url = "jdbc:postgresql://localhost/atm";
    private final String user = "postgres";
    private final String password = "123";
    Scanner in = new Scanner(System.in);

    public ATM() {
    }

    public void balance(Card card) {
        System.out.println("Current balance: " + card.getBalance() + " kzt");
    }


    public void doMyInit(){
        ATM app = new ATM();
        System.out.println("Doing my initialization");
        app.connect();
    }

    public void doMyDestroy(){
        System.out.println("Doing my destruction");
    }
    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);

            if (conn != null) {
                System.out.println("Connected to the PostgreSQL server successfully.");
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    @Override
    public Card bankingProcess(Card card) {
    return card;
    }
}
