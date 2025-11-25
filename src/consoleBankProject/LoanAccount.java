package consoleBankProject;

public class LoanAccount extends Account {

    public LoanAccount(String accountNumber, String ownerName, double balance) {
        super(accountNumber, ownerName, balance);
    }

    public void chargeInterest() {
        setBalance(getBalance() * 1.05);
    }


}
