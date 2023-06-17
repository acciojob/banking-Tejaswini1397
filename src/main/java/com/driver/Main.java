package com.driver;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BankAccount account = new BankAccount("John", 1000);
        account.deposit(500);

            account.withdraw(200);


            String accountNumber = account.generateAccountNumber(4, 10);
            System.out.println("Account Number: " + accountNumber);


        // CurrentAccount example
        CurrentAccount currentAccount = new CurrentAccount("Alice", 6000, "ABCDEFGH");

            currentAccount.validateLicenseId();
            System.out.println("Trade License ID: " + currentAccount.tradeLicenseId);


        // SavingsAccount example
        SavingsAccount savingsAccount = new SavingsAccount("Bob", 0.05, 2000);
        savingsAccount.deposit(10000);
        try {
            savingsAccount.withdraw(1500);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } catch (MaximumWithdrawLimitExceededException e) {
            System.out.println(e.getMessage());
        }
        double simpleInterest = savingsAccount.getSimpleInterest(5);
        double compoundInterest = savingsAccount.getCompoundInterest(12, 5);
        System.out.println("Simple Interest: " + simpleInterest);
        System.out.println("Compound Interest: " + compoundInterest);

        // StudentAccount example
        StudentAccount studentAccount = new StudentAccount("Emma", "XYZ University");
        studentAccount.deposit(2000);
    }
}