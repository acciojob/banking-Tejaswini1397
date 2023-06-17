package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        this.tradeLicenseId=tradeLicenseId;
        if(getMinBalance()<5000){
            throw new InsufficientBalanceException("Insufficient Balance");
        }

    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        char licenseIdChars[]=tradeLicenseId.toCharArray();
        for(int i=1;i<licenseIdChars.length;i++){
            if(licenseIdChars[i]==licenseIdChars[i-1]){
                boolean rearranged=false;
                for (int j = i + 1; j < licenseIdChars.length; j++) {
                    if (licenseIdChars[j] != licenseIdChars[i - 1]) {
                        char temp = licenseIdChars[i];
                        licenseIdChars[i] = licenseIdChars[j];
                        licenseIdChars[j] = temp;
                        rearranged = true;
                        break;
                    }
                }
                if (!rearranged) {
                    throw new Exception("Valid License cannot be generated");
                }
            }
        }
        tradeLicenseId=new String(licenseIdChars);

    }

}
