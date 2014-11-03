package bankApplication;

import static org.junit.Assert.*;


import org.junit.Test;

public class TestBank {

	Bank bank = new Bank();

	@Test
	public void testCreateClientAndAccount() {	
		Client client = new Client("Jack Brown");
		Account account = new Account(10001, 123.26);
		bank.createClientAndAccount(client, account);
		assertEquals(bank.mapSize(), 1);
		
		client = new Client("Gareth Silver");
		account = new Account(10003, 658.26);
		bank.createClientAndAccount(client, account);
		assertEquals(bank.mapSize(), 2);
		
		client = new Client("Gareth Silver");
		account = new Account(10006, 368.26);
		bank.createClientAndAccount(client, account);
		assertEquals(bank.mapSize(), 2);
		
		client = new Client("Bill Brown");
		account = new Account(10008, 69.87);
		bank.createClientAndAccount(client, account);
		assertEquals(bank.mapSize(), 3);
	}

	@Test (expected = IllegalArgumentException.class)
	public void throwsExceptionWhenAccountAlreadyExist() {
		Client client = new Client("Jack Brown");
		Account account = new Account(10001, 123.26);
		bank.createClientAndAccount(client, account);
		bank.createClientAndAccount(client, account);
		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void throwsExceptionWhenRemoveClientDoesntExist() {
		Client client = new Client("Jack Brown");
		Account account = new Account(10001, 123.26);
		bank.createClientAndAccount(client, account);
		
		client = new Client("Unknown Client");
		bank.deleteClient(client);
	}

	@Test
	public void testNumberOfAccounts() {
		Client client = new Client("Gareth Silver");
		Account account = new Account(10006, 368.26);
		bank.createClientAndAccount(client, account);
		
		client = new Client("Bill Brown");
		account = new Account(10008, 69.87);
		bank.createClientAndAccount(client, account);
		
		client = new Client("Bill Brown");
		account = new Account(10012, 69.87);
		bank.createClientAndAccount(client, account);
		assertEquals(bank.numberOfAccounts(client), 2);	
		
		client = new Client("Bill Brown");
		account = new Account(10022, 69.87);
		bank.createClientAndAccount(client, account);
		assertEquals(bank.numberOfAccounts(client), 3);	
		
		client = new Client("Unknown User");
		assertEquals(bank.numberOfAccounts(client), 0);	
	}

	@Test
	public void testDepositMoney() {
		Client client = new Client("Gareth Silver");
		Account account = new Account(10006, 368.26);
		bank.createClientAndAccount(client, account);
		bank.depositMoney(10006, 128.38);
		double balance = bank.getSpecificAccount(client, 10006).getBalance();
		assertEquals(balance, 496.64, 0);
	}
	
	@Test
	public void testSpecificAccount() {
		Client client = new Client("Gareth Silver");
		Account account = new Account(10006, 368.26);
		bank.createClientAndAccount(client, account);
		assertEquals(account, bank.getSpecificAccount(client, 10006));
		assertEquals(null,bank.getSpecificAccount(client, 12345));
	}

	@Test
	public void testWithdrawMoney() {
		Client client = new Client("Gareth Silver");
		Account account = new Account(10006, 368.26);
		bank.createClientAndAccount(client, account);
		bank.withdrawMoney(10006, 128.38);
		double balance = bank.getSpecificAccount(client, 10006).getBalance();
		assertEquals(balance, 239.88, 0);
		assertFalse(bank.withdrawMoney(10006, 928.38));
		assertEquals(balance, 239.88, 0);
	}

	@Test
	public void testDeleteClient() {
		Client client = new Client("Jack Brown");
		Account account = new Account(10001, 123.26);
		bank.createClientAndAccount(client, account);
		
		client = new Client("Gareth Silver");
		account = new Account(10003, 658.26);
		bank.createClientAndAccount(client, account);
		
		client = new Client("Gareth Silver");
		account = new Account(10006, 368.26);
		bank.createClientAndAccount(client, account);
		
		client = new Client("Bill Brown");
		account = new Account(10008, 69.87);
		bank.createClientAndAccount(client, account);
		
		client = new Client("Bill Brown");
		bank.deleteClient(client);
		assertEquals(bank.mapSize(), 2);
		
	}

	@Test
	public void testGetTotalClientBalance() {
		Client client = new Client("Jack Brown");
		Account account = new Account(10001, 123.26);
		bank.createClientAndAccount(client, account);
		
		client = new Client("Gareth Silver");
		account = new Account(10003, 658.26);
		bank.createClientAndAccount(client, account);
		
		client = new Client("Gareth Silver");
		account = new Account(10006, 368.26);
		bank.createClientAndAccount(client, account);
		
		client = new Client("Gareth Silver");
		assertEquals(bank.getTotalClientBalance(client), 1026.52, 0);
	}

}
