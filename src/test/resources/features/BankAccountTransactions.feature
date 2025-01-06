Feature: Bank Account Management

  Scenario: Account Holder Balance Inquiry
    Given I have a bank account with a balance of 5000.0 and a minimum balance of 1000.0
    When I inquire about the balance
    Then the account balance should be 5000.0

  Scenario: Successful Deposit
    Given I have a bank account with a balance of 5000 and a minimum balance of 1000
    When I deposit 300
    Then the account balance should be 5300

  Scenario: Successful Withdrawal
    Given I have a bank account with a balance of 5000 and a minimum balance of 1000
    When I withdraw 200
    Then the account balance should be 4800

  Scenario: Insufficient Funds Withdrawals
    Given I have a bank account with a balance of 5000 and a minimum balance of 1000
    When I withdraw 4000
    Then an exception should be thrown indicating insufficient funds

  Scenario: Successful Fund Transfer Between Accounts
    Given I have two bank accounts with a balance of 5000 and a minimum balance of 1000 each
    When I transfer 300 from the first account to the second account
    Then the first account balance should be 4700
    And the second account balance should be 5300