package consoleBankProject;

public class MortgageAccount extends Account {

    public MortgageAccount(String accountNumber, String ownerName, double balance) {
        super(accountNumber, ownerName, balance);
    }
    public void addMonthlyFee(){
        double current = getBalance();
        if (current - 10 < 0) {
            System.out.println("Warning: Balance will be negative!");
        }
        setBalance(current - 10);
    }
}
