package bankApplication;


public class Client {
	
	private String clientID;
	
	public Client (String id) {	
		
		if (id != null) 
			this.setClientID(id);
		else 
			throw new IllegalArgumentException("The client name cannot be null");		
	}

	/**
	 * @return the clientID
	 */
	public String getClientID() {
		return clientID;
	}

	/**
	 * @param clientID the clientID to set
	 */
	public void setClientID(String clientID) {
		this.clientID = clientID;
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        
        if (o == null || getClass() != o.getClass()) 
        	return false;

        Client that = (Client) o;

        if (clientID != that.clientID) 
        	return false;

        return true;
    }

    @Override
    public int hashCode() {  	
        int result = clientID.hashCode();
        return result;
    }
	
	@Override
	public String toString() {
		return "Client ID: " + clientID;

	}

}
