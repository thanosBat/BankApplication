package bankApplication;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Bank implements BankInterface{

	private Map <Client, List<Account> > bankMap;
	
	
	public Bank() {
		bankMap = new HashMap <Client, List <Account> >();
	}
	
	
	public void createClientAndAccount(Client client, Account account) {
		
		if (!bankMap.containsKey(client)) {
			List <Account> accountsList = new LinkedList <Account> ();
			accountsList.add(account);
			bankMap.put(client, accountsList);
		}
		else {
			if (bankMap.get(client).contains(account))
				throw new IllegalArgumentException("This account already exists");
			else
				bankMap.get(client).add(account);
		}	
	}
	
	
	public int mapSize() {
		return bankMap.size();
	}
	
	
	public int numberOfAccounts(Client client) {
		
		if (bankMap.containsKey(client))
			return bankMap.get(client).size();
		else 
			return 0;	
	}

	
	public void depositMoney(int accountNumber, double amount) {
		
		boolean flag = false;
		
		for(Client key : bankMap.keySet()) {
		    List<Account> accountsList  = bankMap.get(key);
		    	for (Account account : accountsList) {
		    		if (account.getAccountID() == accountNumber) {
		    			account.deposit(amount);
		    			flag = true;
		    			break;
		    		}		
		    	}
		}
		
		if (!flag)
			throw new IllegalArgumentException("The accountNumber: " + accountNumber + " does not exist.");
	}

	
	public boolean withdrawMoney(int accountNumber, double amount) {
		
		for(Client key : bankMap.keySet()) {
		    List<Account> accountsList  = bankMap.get(key);
		    	for (Account account : accountsList) {
		    		if (account.getAccountID() == accountNumber) {
		    			return account.withdraw(amount);
		    		}		
		    	}
		}
		
		System.out.println("The accountNumber: " + accountNumber + " does not exist.");
		return false;
	}
	
	
	public boolean clientExist(Client client) {
		
		if (bankMap.containsKey(client)) 
			return true;
		
		return false;
	}
	
	
	public void deleteClient(Client client) {
		
		if (clientExist(client)) 
			bankMap.remove(client);
		else
			throw new IllegalArgumentException("This client does not exist");
	}
	
	
	public double getTotalClientBalance(Client client) {
		
		double balance = 0;
	    List<Account> accountsList = bankMap.get(client);
    	for (Account account : accountsList) {
    		balance = balance + account.getBalance();
    	}
    	
    	return balance;
	}
	
	
	public Account getSpecificAccount(Client client, int accountNumber) {
	
		if (clientExist(client)) {
			List<Account> accountsList = bankMap.get(client);
			for (Account account : accountsList) {
	    		if (account.getAccountID() == accountNumber) { 
	    			return account;
	    		}
	    	}
		}
		
		System.out.println("This account does not exist");
		return null;
	}	
	
}
