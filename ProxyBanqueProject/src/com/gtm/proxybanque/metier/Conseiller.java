package com.gtm.proxybanque.metier;

import java.util.ArrayList;
import java.util.List;

import com.gtm.proxybanque.constants.ApplicationConstants;

public class Conseiller {
	
	private List<Client> clients = new ArrayList<Client>(ApplicationConstants.MAX_CLIENTS);

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
	
		this.clients = clients;
	}
	

}
