package org.Test;

import org.Test.BankAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankAccountTest {
    public static final int OPEN_BALANCE = 500;
    public static final int MINIMUM_BALANCE = 1000;
    public static final int DEPOSIT_AMOUNT = 300;
    BankAccount accountholder1 = new BankAccount(500, 1000);
    BankAccount accountholder2 = new BankAccount(800, 1000);

    @Test
    public void accountHolder1() {
        System.out.println("Bank Balance: " + accountholder1.getBalance());
        Assertions.assertEquals(500, accountholder1.getBalance());
        System.out.println("Minimum Balance:"+accountholder1.getMinimumbalance());
        Assertions.assertEquals(-1000,1000);
        System.out.println("Bank Balance: " + accountholder1.withdraw(200));
        Assertions.assertEquals(300, accountholder1.getBalance());
        System.out.println("Bank Balance: " + accountholder1.deposit(300));
        Assertions.assertEquals(600, accountholder1.getBalance());
    }

    @Test
    public void depositCashToAcccount() {
        BankAccount bankAccount = new BankAccount(OPEN_BALANCE, MINIMUM_BALANCE);
        System.out.println("Bank Balance: " + bankAccount.deposit(DEPOSIT_AMOUNT));
        Assertions.assertEquals(OPEN_BALANCE+DEPOSIT_AMOUNT, bankAccount.getBalance());
    }

    @Test
    public void setAccountholder2(){
        System.out.println("Bank Balance:"+ accountholder2.getBalance());
        Assertions.assertEquals(800,accountholder2.getBalance());
        System.out.println("Bank Balance: " + accountholder2.withdraw(200));
        Assertions.assertEquals(600, accountholder2.getBalance());
        System.out.println("Bank Balance: " + accountholder2.deposit(300));
        Assertions.assertEquals(900, accountholder2.getBalance());
    }
    }
