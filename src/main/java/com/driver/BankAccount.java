package com.driver;
import java.util.Random;
import java.util.*;
public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount() {
    }


    public BankAccount(String name, double balance, double minBalance) {
        this.name=name;
        this.balance=balance;
        this.minBalance=minBalance;

    }

    public BankAccount(String name, int i) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        Random random=new Random();
        StringBuilder accountNumber=new StringBuilder();
        int remainingSum=0;
        for(int i=0;i<digits;i++){
            int digit=random.nextInt(remainingSum+1);
            if(i==digits-1 && digit!=remainingSum ){
                throw new AccountNumberGenerationException("Account Number cannot be generated");
            }
            remainingSum-=digit;
            accountNumber.append(digit);
        }

        return accountNumber.toString();
    }

    public void deposit(double amount) {
        balance+=amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(balance-amount<minBalance){
           throw new InsufficientBalanceException("Insufficient Balance");
        }
        balance-=amount;
    }

}