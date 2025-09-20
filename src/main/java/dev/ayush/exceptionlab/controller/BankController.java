package dev.ayush.exceptionlab.controller;

import dev.ayush.exceptionlab.service.BankService;

public class BankController {
    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    public void simulate() {
        try {
            bankService.createAccount(1, 1000);
            bankService.createAccount(2, 500);
            bankService.transfer(1, 2, 200);
            bankService.withDraw(2, 1000); // Will fail
        } catch (Exception e) {
            LoggerUtil.logException(e);
            System.out.println("Error: " + e.getMessage());
        }
    }
}
