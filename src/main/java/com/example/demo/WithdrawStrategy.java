package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class WithdrawStrategy implements BankService{
    @Override
    public Card bankingProcess(Card card) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter sum: ");
        double balance = in.nextDouble();
        System.out.println("Withdraw was successfully finished!");
        if(card.getBalance()-balance < 0){
            System.out.println("Error! Not enough money in your card for withdrawing!");
        } else
            card.setBalance(card.getBalance()-balance);
        System.out.println("Current balance: " + card.getBalance() + " kzt");
        return card;
    }
}
