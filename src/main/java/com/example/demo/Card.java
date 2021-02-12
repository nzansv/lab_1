package com.example.demo;
import java.util.*;
public class Card {
    private String cardNo, expDate;
    private int cvv, pin;
    private double balance;
    Scanner in = new Scanner(System.in);

    public Card(String cardNo, String expDate, int cvv, int pin, double balance) {
        this.cardNo = cardNo;
        this.expDate = expDate;
        this.cvv = cvv;
        this.pin = pin;
        this.balance = balance;
    }

    public Card() {
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public void changePIN () {
        System.out.println("Input new PIN: ");
        int pin = in.nextInt();
        in.nextLine();
        this.pin = pin;
        System.out.println("PIN successfully changed to " + pin);
    }
}
