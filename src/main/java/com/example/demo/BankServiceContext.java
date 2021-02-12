package com.example.demo;

public class BankServiceContext {


    private BankService bankService;

    public BankService getBankService() {
        return bankService;
    }

    public void setBankService(BankService bankService) {
        this.bankService = bankService;
    }

    public BankServiceContext(BankService bankService) {
        this.bankService = bankService;
    }

    public  BankServiceContext(){ }

    public void bankingProcess(Card card) {
        bankService.bankingProcess(card);
    }

}
