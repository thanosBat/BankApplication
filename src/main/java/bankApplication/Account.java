package bankApplication;

public class Account {
	
	private int accountID;
	private double balance;
	
	public Account(int accountID, double balance) {
		this.setAccountID(accountID);
		this.setBalance(balance);
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void deposit(double amount) {
		this.balance = this.balance + amount;
	}
	
	public boolean withdraw(double amount) {
		
		if (this.balance >= amount) {
			this.balance = this.balance - amount;
			return true;
		}
		
		System.out.println("You cannot withdraw this ammount.");
		return false;
	}
	
	@Override
	public boolean equals(Object o) {
		
        if (this == o) return true;
        
        if (o == null || getClass() != o.getClass()) 
        	return false;

        Account that = (Account) o;

        if (accountID != that.accountID) 
        	return false;

        return true;
	}
	
	@Override
	public int hashCode() {
		int result = accountID;
		return result;
	}
	
	@Override
	public String toString() {
		return "AccountID: " + accountID + ", Balance: " + balance;
	}
	

}
