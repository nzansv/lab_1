package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Account {
    private String login;
    private String phoneNumber;
    private String password;
    @Qualifier("card")
    private Card card;


    @Autowired
    public Account(@Value("${account.login}") String login,@Value("${account.phoneNumber}") String phoneNumber,@Value("${account.password}") String password, Card card) {
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


}
