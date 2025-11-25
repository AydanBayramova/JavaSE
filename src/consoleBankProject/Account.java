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

    public static void main(String[] args) {
        Account[] accounts = new Account[100];
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n--- BANK MENU ---");
            System.out.println("1. Create account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Special Action (Interest/Bonus/Fee)");
            System.out.println("5. Show Info");
            System.out.println("0. Exit");
            System.out.print("Seçim edin: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    String accNum = scanner.next();
                    System.out.print("Enter Owner Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Balance: ");
                    double balance = scanner.nextDouble();

                    System.out.println("Type: 1-Loan, 2-Deposit, 3-Mortgage");
                    int type = scanner.nextInt();

                    Account newAccount = null;

                    if (type == 1) {
                        newAccount = new LoanAccount(accNum, name, balance);
                    } else if (type == 2) {
                        newAccount = new DepositAccount(accNum, name, balance);
                    } else if (type == 3) {
                        newAccount = new MortgageAccount(accNum, name, balance);
                    }
                    if (newAccount != null) {
                        boolean added = false;
                        for (int i = 0; i < accounts.length; i++) {
                            if (accounts[i] == null) {
                                accounts[i] = newAccount;
                                System.out.println("Account created");
                                added = true;
                                break;
                            }
                        }
                        if (!added) {
                            System.out.println("there is not enough space in array");
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter Account Number: ");
                    String accNumber = scanner.next();
                    System.out.println("Enter the amount");
                    double amount = scanner.nextDouble();
                    boolean foundDeposit = false;
                    for (int i = 0; i < accounts.length; i++) {
                        if (accounts[i] != null && accounts[i].getAccountNumber().equals(accNumber)) {
                            accounts[i].deposit(amount);
                            System.out.println("Your amount updated successfully:" + accounts[i].getBalance());
                            foundDeposit = true;
                            break;
                        }
                    }
                    if (!foundDeposit) System.out.println("cannot find your account number" + accNumber);
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    String accN = scanner.next();
                    System.out.println("Enter the amount");
                    double amountDraw = scanner.nextDouble();
                    boolean withDraw = false;
                    for (int i = 0; i < accounts.length; i++) {
                        if (accounts[i] != null && accounts[i].getAccountNumber().equals(accN)) {
                            accounts[i].withdraw(amountDraw);
                            System.out.println("current balance:" + accounts[i].getBalance());
                            withDraw = true;
                            break;
                        }
                    }
                    if (!withDraw) System.out.println("Cannot find your account number " + accN);
                    break;
                case 4:
                    System.out.print("Enter Account Number for Special Action: ");
                    String searchNum = scanner.nextLine();
                    boolean found = false;

                    for (int i = 0; i < accounts.length; i++) {
                        if (accounts[i] != null && accounts[i].getAccountNumber().equals(searchNum)) {

//5678   //7890
                            if (accounts[i] instanceof LoanAccount) {
                                LoanAccount loanAcc = (LoanAccount) accounts[i];
                                loanAcc.chargeInterest();
                                System.out.println("Loan Account: Interest charged.");
                            } else if (accounts[i] instanceof DepositAccount) {
                                ((DepositAccount) accounts[i]).addMonthlyBonus();
                                System.out.println("Deposit Account: Bonus added.");
                            } else if (accounts[i] instanceof MortgageAccount) {
                                ((MortgageAccount) accounts[i]).addMonthlyFee();
                                System.out.println("Mortgage Account: Fee added.");
                            }

                            found = true;
                            break;
                        }
                    }

                    if (!found) System.out.println("Hesab tapılmadı!");
                    break;
                case 5:
                    System.out.print("Məlumatına baxmaq istədiyiniz hesab nömrəsini yazın: ");
                    String infoAccNum = scanner.next();
                    boolean foundInfo = false;

                    for (int i = 0; i < accounts.length; i++) {

                        if (accounts[i] != null && accounts[i].getAccountNumber().equals(infoAccNum)) {

                            System.out.println("\n--- HESAB MƏLUMATLARI ---");

                            System.out.println(accounts[i]);
                            foundInfo = true;
                            break;
                        }
                    }

                    if (!foundInfo) {
                        System.out.println("Axtardığınız hesab tapılmadı!");
                    }
                    break;
                case 0:
                    System.out.println("Proqramdan istifadə etdiyiniz üçün təşəkkürlər. Sağ olun!");
                    isRunning = false;
                    break;
            }


        }


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
