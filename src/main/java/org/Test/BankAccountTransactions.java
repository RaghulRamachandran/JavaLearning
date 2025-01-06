package org.Test;

public class BankAccountTransactions {
    private double balance;
    private double minimumBalance;
    private int  AccountNumber;
    private String Password;

    public BankAccountTransactions(double balance,double minimumBalance,int AccountNumber,String Password) {
        this.balance = balance;
        this.minimumBalance = minimumBalance;
        this.AccountNumber=AccountNumber;
        this.Password=Password;
    }
    public void depositAmount(double amount) {
        balance = balance + amount;
    }

    public void withdrawAmount(double amount) {
        balance = balance - amount;
    }

    public double getBalance() {
        return balance;
    }

}
