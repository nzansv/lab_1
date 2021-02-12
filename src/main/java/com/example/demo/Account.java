package com.example.demo;

public class Account {
    private String login, phoneNumber, password;

    private Card card;

    public Account(String login, String phoneNumber, String password, Card card) {
        this.login = login;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.card = card;
    }
    public Account(){
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Account{" +
                "login='" + login + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", card=" + card +
                '}';
    }
}
