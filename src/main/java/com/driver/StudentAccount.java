package com.driver;

public class StudentAccount extends BankAccount{

    String  institutionName;

    public StudentAccount(String name, String  institutionName) {
        super(name,0);
        this.institutionName=institutionName;
   }

}
