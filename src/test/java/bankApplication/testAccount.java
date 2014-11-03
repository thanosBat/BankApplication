package bankApplication;

import static org.junit.Assert.*;

import org.junit.Test;

public class testAccount {
	
	Account account = new Account(12345, 500.32);

	@Test
	public void testDeposit() {
		account.deposit(105.29);
		assertTrue(account.getBalance() == 605.61);
		account.deposit(1.05);
		assertFalse(account.getBalance() == 605.61);
		
	}
	
	@Test
	public void testWithdraw() {
		Account account = new Account(54321, 500.32);
		assertTrue(account.withdraw(150.32));
		assertTrue(account.getBalance() == 350.00);	
		
		assertFalse(account.withdraw(500.63));
	}
	
	@Test
	public void testHashCode() {
		Account account2 = new Account(12345, 500.32);
		assertTrue(account2.hashCode() == account.hashCode());
		Account account3 = new Account(12345, 700.15);
		assertTrue(account.hashCode() == account3.hashCode());
		Account account4 = new Account(00007, 500.32);
		assertFalse(account.hashCode() == account4.hashCode());
	}

	@Test
	public void testGetAccountID() {
		assertEquals(12345, account.getAccountID());
		assertFalse(account.getAccountID() == 123);
	}

	@Test
	public void testSetAccountID() {
		account.setAccountID(0007);
		assertFalse(account.getAccountID() == 12345);
		assertEquals(0007, account.getAccountID());
	}

	@Test
	public void testGetBalance() {
		assertEquals(500.32, account.getBalance(), 0);
		assertFalse(account.getBalance() == 500.31);
	}

	@Test
	public void testSetBalance() {
		account.setBalance(123.45);
		assertFalse(account.getBalance() == 500.32);
		assertEquals(123.45, account.getBalance(), 0);
	}

	@Test
	public void testEqualsObject() {
		Account account2 = new Account(12345, 500.32);
		assertTrue(account.equals(account2));
		account2 = null;
		assertFalse(account.equals(account2));
		Account account3 = new Account(12345, 700.98);
		assertTrue(account.equals(account3));
		Account account4 = new Account(10008, 500.32);
		assertFalse(account.equals(account4));
		Account account5 = account;
		assertTrue(account.equals(account5));
	}

	@Test
	public void testToString() {
		assertEquals("AccountID: 12345, Balance: 500.32", account.toString());
	}

}
