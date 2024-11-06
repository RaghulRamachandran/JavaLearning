package org.Test;

public class BankAccount {
    private double balance;
    private double minimumbalance;


    public BankAccount(double balance, double minimumbalance) {
        this.balance = balance;
        this.minimumbalance = minimumbalance;

    }

    public double getBalance() {
        return balance;
    }

    public double getMinimumbalance() {
        return minimumbalance;
    }

    public double withdraw(double amount) {
        if (balance - amount < minimumbalance) {
            balance -= amount;
            return amount;
        } else {
            throw new RuntimeException();
        }
    }
    public double deposit(double amount){
        return balance+=amount;
    }
    }

