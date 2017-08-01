package com.gtm.proxybanque.service;

import com.gtm.proxybanque.metier.Client;
import com.gtm.proxybanque.metier.Compte;

public class ClientService {
	
	/**
	 * Method prints all accounts from one client. 
	 * @param client Information is read from this client.
	 */
	public void readComptes(Client client) {
		
		for(Compte compte: client.getComptes()) {
			System.out.println(compte.toString());
		}
	}
	
}
