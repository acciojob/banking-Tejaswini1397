package com.driver;

public class MaximumWithdrawLimitExceededException extends Exception{
    public MaximumWithdrawLimitExceededException(String message){
        super(message);
    }
}
