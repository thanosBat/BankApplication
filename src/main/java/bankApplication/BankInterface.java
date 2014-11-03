package bankApplication;

/**
 * The interface that your class will have to implement
 * For amount, please 
 */
public interface BankInterface {

    public void depositMoney (int accountNumber, double amount);

    /**
     * Returns false if there is not enough money to withdraw.
     */
    public boolean withdrawMoney (int accountNumber, double amount);

}
