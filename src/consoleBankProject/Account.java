package consoleBankProject;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Account {

    private String accountNumber;

    private String ownerName;

    private double balance;


    public void setAccountNumber(String accountNumber) {

        if (accountNumber != null && !accountNumber.isEmpty() && accountNumber.length() >= 4) {
            this.accountNumber = accountNumber;
        } else {
            System.out.println("Invalid account number");
        }
    }

    public void setOwnerName(String ownerName) {

        if (ownerName != null && !ownerName.isEmpty() && ownerName.length() >= 3) {
            this.ownerName = ownerName;
        } else {
            System.out.println("Invalid owner name");
        }
    }

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Balance cannot negative");
        }
    }

    public Account(String accountNumber, String ownerName, double balance) {
        setAccountNumber(accountNumber);
        setOwnerName(ownerName);
        setBalance(balance);
    }



    public void deposit(double amount) {
        if (amount >= 0) {
            this.balance += amount;
        } else {
            System.out.println("Amount can't be negative");
        }
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            this.balance -= amount;
        } else {
            System.out.println("Not enough money to withdraw");
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
