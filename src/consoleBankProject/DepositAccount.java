package consoleBankProject;

public class DepositAccount extends Account {

    public DepositAccount(String accountNumber, String ownerName, double balance) {
        super(accountNumber, ownerName, balance);
    }
    public void addMonthlyBonus(){

        double currentBonus=getBalance();
        double increaseBalance = currentBonus * 0.01;
        setBalance(getBalance()+increaseBalance);
        System.out.println("Kredit hesabiniz hesablandi:"+getBalance());
    }

}
