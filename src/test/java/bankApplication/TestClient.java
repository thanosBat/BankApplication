package bankApplication;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestClient {

	Client client = new Client("JS12345");
	
	@Test (expected = IllegalArgumentException.class)
	public void throwsExceptionWhenNegativeNumbersAreGiven() {
	    Client client2 = new Client(null);
	}

	@Test
	public void testGetClientID() {
		assertEquals("JS12345", client.getClientID());
		assertFalse(client.getClientID().equals("JS123"));
	}

	@Test
	public void testSetClientID() {
		client.setClientID("JS007");
		assertFalse(client.getClientID().equals("JS12345"));
		assertEquals("JS007", client.getClientID());
	}
	
	@Test 
	public void testEquals() {
		Client client2 = new Client("JS12345");
		assertTrue(client.equals(client2));
		client2 = null;
		assertFalse(client.equals(client2));
		Client client3 = new Client("JS007");
		assertFalse(client.equals(client3));
		Client client4 = client;
		assertTrue(client.equals(client4));
	}
	
	@Test
	public void testHashCode(){
		Client client2 = new Client("JS12345");
		assertTrue(client2.hashCode() == client.hashCode());
		client2 = new Client("JS12345");
		assertTrue(client2.hashCode() == client.hashCode());
		client2 = new Client("JS007");
		assertFalse(client2.hashCode() == client.hashCode());
	}

	@Test
	public void testToString() {
		assertEquals("Client ID: JS12345", client.toString());
	}

}
