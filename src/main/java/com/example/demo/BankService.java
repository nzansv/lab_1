package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public interface BankService {
    public Card bankingProcess(Card card);
}
