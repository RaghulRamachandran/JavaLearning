package org.Test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BankAccount {
    private double balance;
    private double minimumbalance;
    private int  AccountNumber;
    private String Password;
    private double DEPOSIT_AMOUNT;

    public BankAccount(double balance,double minimumbalance,int AccountNumber,String Password) {
        this.balance = balance;
        this.minimumbalance = minimumbalance;
        this.AccountNumber=AccountNumber;
        this.Password=Password;
    }

    public BankAccount(double balance,double minimumbalance,int AccountNumber,String Password,double DEPOSIT_AMOUNT) {
        this.balance = balance;
        this.minimumbalance = minimumbalance;
        this.AccountNumber=AccountNumber;
        this.Password=Password;
        this.DEPOSIT_AMOUNT=DEPOSIT_AMOUNT;
    }

    public void setDepositAmount(double depositAmount) {
        balance = balance + depositAmount;
    }

    public void setWithdrawAmount(double depositAmount) {
        balance = balance - depositAmount;
    }

    public double getBalance() {
        return balance;
    }

    public double getMinimumbalance() {
            return minimumbalance;
    }
    public int getAccountNumber(){
        return AccountNumber;
    }

    public String getPassword() {
        return Password;

    }
    public double getDEPOSIT_AMOUNT(){
        return DEPOSIT_AMOUNT;
    }

    public double withdraw(double amount) {
        if (balance - amount > minimumbalance) {
            balance -= amount;
            return amount;
        } else {
            throw new RuntimeException();
        }
    }
    public double deposit(double amount){

        return balance+=amount;
    }
    public int ValidateAccountNumber() {

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter your 10-digit account number:");
            String accountNumber = sc.nextLine();
            if (accountNumber.length() == 10 && accountNumber.matches("[0-9]+")) {
                System.out.println("Valid account number entered.");
                return Integer.parseInt(accountNumber);
            } else {
                System.out.println("Invalid account number. Please enter 10 digits only.");
            }
        }
    }
    public String ValidatePassword(){

        System.out.println("Please enter your password");
        Scanner sc=new Scanner(System.in);
        String P=sc.nextLine();
        Pattern pattern = Pattern.compile("[]a-zA-Z0-9]");
        Matcher matcher = pattern.matcher("[a-zA-Z0-9]");
        boolean matchFound = matcher.find();
        if (matchFound) {
            System.out.println("Valid Password");
        } else {
            System.out.println("Sorry please enter the correct password");
        }
        return P;
    }

    public static void main(String[] args) {
        BankAccount AccountTest=new BankAccount(5000,1000,1234567890,"Password",5000);
        AccountTest.ValidateAccountNumber();
        AccountTest.ValidatePassword();
    }
}





