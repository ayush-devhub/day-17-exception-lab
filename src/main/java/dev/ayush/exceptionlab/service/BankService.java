package dev.ayush.exceptionlab.service;

import dev.ayush.exceptionlab.exception.*;
import dev.ayush.exceptionlab.model.Account;

import java.util.HashMap;
import java.util.Map;

public class BankService {
    private final Map<Integer, Account> accounts = new HashMap<>();

    public void createAccount(int id, double balance) {
        accounts.put(id, new Account(id, balance));
    }

    public void deposit(int accountId, double balance) throws InvalidAccountException {
        if (balance < 0) {
            throw new NegativeAmountException("Cannot deposit negative amount.");
        }
        Account account = getAccount(accountId);
        account.setBalance(account.getBalance() + balance);
    }

    public void withDraw(int accountId, double balance) throws BankException {
        if (balance < 0) {
            throw new NegativeAmountException("Cannot withdraw negative amount.");
        }
        Account acc = getAccount(accountId);
        if (acc.getBalance() < balance) {
            throw new InsufficientFundsException("Insufficient Fund. Your current balance is: " + acc.getBalance());
        }
        acc.setBalance(acc.getBalance() - balance);
    }

    public void transfer(int fromId, int toId, double amount) throws BankException {
        try {
            withDraw(fromId, amount);
            deposit(toId, amount);
        } catch (BankException | NegativeAmountException e) {
            throw new TransferFailedException("Transfer failed from " + fromId + " to " + toId, e);
        }

    }

    private Account getAccount(int accountId) throws InvalidAccountException {
        Account acc = accounts.get(accountId);
        if (acc == null) {
            throw new InvalidAccountException("No account found with id: " + accountId);
        }
        return acc;
    }
}
