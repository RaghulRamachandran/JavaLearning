package org.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class BankAccountTest {

    BankAccount accountholder1 = new BankAccount(5000,1000,1234567890,"Password",5000);
    BankAccount accountholder2 = new BankAccount(5000,1000,1234567890,"Password",5000);
    @Test
    public void accountHolder1() {
        System.out.println("Bank Balance: " + accountholder1.getBalance());
        Assertions.assertEquals(5000, accountholder1.getBalance());
        System.out.println("Minimum Balance:" + accountholder1.getMinimumbalance());
        Assertions.assertEquals(1000, 1000);
        System.out.println("Bank Balance: " + accountholder1.withdraw(200));
        Assertions.assertEquals(4800, accountholder1.getBalance());
        System.out.println("Bank Balance: " + accountholder1.deposit(300));
        Assertions.assertEquals(5100, accountholder1.getBalance());
    }

    @Test
    public void depositCashToAcccount() {

        System.out.println("Bank Balance: " + accountholder1.deposit(accountholder1.getDEPOSIT_AMOUNT()));
        Assertions.assertEquals(accountholder1.getBalance() + accountholder1.getDEPOSIT_AMOUNT(), accountholder1.getBalance());
    }

    @Test
    public void FundTransferBetweenAccount1andAccount2() {
        int WithdrawingfromAccountholder1 = (int) accountholder1.withdraw(300);
        System.out.println(WithdrawingfromAccountholder1);
        Assertions.assertEquals(4700, accountholder1.getBalance());
        accountholder2.deposit(WithdrawingfromAccountholder1);
        Assertions.assertEquals(5300, accountholder2.getBalance());
    }

    @Test
    public void setAccountholder2() {
        System.out.println("Bank Balance:" + accountholder2.getBalance());
        Assertions.assertEquals(5000, accountholder2.getBalance());
        System.out.println("Bank Balance: " + accountholder2.withdraw(200));
        Assertions.assertEquals(4800, accountholder2.getBalance());
        System.out.println("Bank Balance: " + accountholder2.deposit(300));
        Assertions.assertEquals(5100, accountholder2.getBalance());
    }

    @Test
    public void CheckAccountNumber() {
        Assertions.assertEquals(1234567890, accountholder1.getAccountNumber());
    }
}