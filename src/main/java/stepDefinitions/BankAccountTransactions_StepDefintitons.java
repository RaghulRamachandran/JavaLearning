package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.Test.BankAccountTransactions;
import org.junit.Assert;

public class BankAccountTransactions_StepDefintitons {

    private BankAccountTransactions account1;
    private BankAccountTransactions account2;
    private  double  initialBalance;
    private double minimumBalance;
    @Given("I have a bank account with a balance of {double} and a minimum balance of {double}")
    public void i_have_a_bank_account_with_a_balance_of_and_a_minimum_balance_of(double balance, double minBalance) {
        initialBalance=balance;
        minimumBalance=minBalance;
        account1 = new BankAccountTransactions (5000.0,1000.0,1234567890,"Password");
    }
    @When("I inquire about the balance")
    public void i_inquire_about_the_balance() {
        System.out.println(account1.getBalance());
    }
    @Then("the account balance should be {double}")
    public void the_account_balance_should_be(double balance) {
        Assert.assertEquals(account1.getBalance(),balance,0.001);
    }
    @When("I deposit {double}")
    public void i_deposit(double amount) {
        account1.depositAmount(amount);
    }

    @When("I withdraw {double}")
    public void i_withdraw(double withdrawAmount) {
        account1.withdrawAmount(withdrawAmount);
    }

    @Then("an exception should be thrown indicating insufficient funds")
    public void an_exception_should_be_thrown_indicating_insufficient_funds() {
        Assert.assertTrue(account1.getBalance() >= minimumBalance);
    }

    @Given("I have two bank accounts with a balance of {double} and a minimum balance of {double} each")
    public void i_have_two_bank_accounts_with_a_balance_of_and_a_minimum_balance_of_each(double balance, double minBalance) {
        initialBalance=balance;
        minimumBalance=minBalance;
        account1 = new BankAccountTransactions (5000.0,1000.0,1234567890,"Password");
        account2 = new BankAccountTransactions (5000.0,1000.0,1234567891,"Password");
    }

    @When("I transfer {double} from the first account to the second account")
    public void i_transfer_from_the_first_account_to_the_second_account(double transferAmount) {
        account1.withdrawAmount(transferAmount);
        account2.depositAmount(transferAmount);
    }

    @Then("the first account balance should be {double}")
    public void the_first_account_balance_should_be(double balance) {
        Assert.assertEquals(account1.getBalance(),balance,0.001);
    }

    @And("the second account balance should be {double}")
    public void the_second_account_balance_should_be(double balance) {
        Assert.assertEquals(account2.getBalance(),balance,0.001);
    }

}
